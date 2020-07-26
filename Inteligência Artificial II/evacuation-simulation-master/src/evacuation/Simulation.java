package evacuation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.ReentrantLock;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Eliel
 */

public class Simulation extends Application
{
    private static ReentrantLock mutex;
    private static Integer numberOfAgents;
    private static Integer lines;
    private static Integer columns;
    private static Integer height;
    private static Integer width;
    private static GraphicsContext context;
    private static String[] arg;
    public static Evacuation evacuation;
    private static ArrayList<Square> dynamicToRender;
    private static ArrayList<Square> staticToRender;
    private static ReentrantLock lock;

    
    public static void main(String[] args) {
        
        mutex = new ReentrantLock(true);
        arg = new String[]{args[0],args[1],args[2]};
        Simulation.numberOfAgents = new Integer(args[0]);
        Simulation.lines = new Integer(args[1]);
        Simulation.columns = new Integer(args[2]);
        Simulation.height = new Integer((Simulation.lines*50)+1);
        Simulation.width = new Integer((Simulation.columns*50)+1);
        Simulation.context = null;
        launch(args);
    }
    
    public static ReentrantLock getLock() {
        return mutex;
    }
    
    @Override
    public void start(Stage theStage) {
        dynamicToRender = new ArrayList<>();
        staticToRender = new ArrayList<>();
        lock = new ReentrantLock();
        theStage.setTitle("Evacuation Simulation");
        theStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
        Group root = new Group();
        Scene theScene = new Scene( root );
        Canvas canvas = new Canvas( this.width, this.height );
        root.getChildren().add( canvas );
        theStage.setScene( theScene );
        this.context = canvas.getGraphicsContext2D();
        
        Simulation.evacuation = new Evacuation(arg);
        
        new AnimationTimer()
        {
            @Override
            public void handle(long currentNanoTime)
            {
                
                lock.lock();
                try {
                    //Simulation.context.clearRect(0, 0, Simulation.width,Simulation.height);
                    dynamicToRender.forEach((square) -> {
                        renderUnique(square);
                    }); dynamicToRender.clear();
                } finally {
                    lock.unlock();
                }
                
//                Square[][] squares = Simulation.evacuation.ROOM.squares();
//                for (Square[] square : squares) {
//                    for (Square square1 : square) {
//                        if(!square1.getType().equals(ObjectType.EMTPY))
//                        {
//                            square1.getSprite().render(Simulation.context);
//                        }
//                    }
////                    System.out.println();
//                }
            }
        }.start();
        
        render(Evacuation.ROOM.squares());
        
        theStage.show();
        
    }
    
    public static void queueDynamicChange(Square square)
    {
        lock.lock();
        try {
            dynamicToRender.add(square);
        } finally {
            lock.unlock();
        }
    }
    
    public static void queueStaticChange(Square square)
    {
        staticToRender.add(square);
    }
    
    public static void render(Square[][] squares) {
        Simulation.context.clearRect(0, 0, Simulation.width,Simulation.height);
        //Square[][] squares = Simulation.evacuation.ROOM.squares();
        for (Square[] square : squares) {
            for (Square square1 : square) {
                if ((square1.getType().equals(ObjectType.PERSON)) || (square1.getType().equals(ObjectType.EXIT)) || (square1.getType().equals(ObjectType.FIRE))) {
                    square1.getSprite().render(Simulation.context);
                }
            }
            //System.out.println();
        }
    }
    
    public void renderUnique(Square sqr) {
        
        Simulation.context.clearRect(sqr.getPosition().x*sqr.getSprite().getBoundary().getWidth(),
                sqr.getPosition().y*sqr.getSprite().getBoundary().getHeight(),
                sqr.getSprite().getBoundary().getWidth(),
                sqr.getSprite().getBoundary().getHeight());
        if(!sqr.getType().equals(ObjectType.EMTPY))
        {
            sqr.getSprite().render(Simulation.context);
        }
//        if ((sqr.getType().equals(ObjectType.PERSON)) || (sqr.getType().equals(ObjectType.EXIT)) || (sqr.getType().equals(ObjectType.FIRE))) {
//            sqr.getSprite().render(Simulation.context);
//        }
    }
}
