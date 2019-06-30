using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dijkstra
{
    class Program
    {
        static void Main(string[] args)
        {

            bool continua = true;
            Grafo grafo = new Grafo();

            while (true)
            {
                Console.WriteLine("1) Inserir Vertice;");
                Console.WriteLine("2) Inserir Aresta;");
                Console.WriteLine("3) Rodar Dijkstra;");
                Console.WriteLine("4) Mostrar a Lista de Adjacencias");

                var valor = Console.ReadKey();

                if(valor.Key == ConsoleKey.Escape)
                {
                    return;
                }

                if (valor.Key == ConsoleKey.NumPad1 || valor.Key == ConsoleKey.D1)
                {
                    Vertice verticeNova = null;
                    do { 
                        Console.WriteLine("Informe o nome do vertice");
                        verticeNova = new Vertice(Console.ReadLine());
                    } while(grafo.AdicionaVertice(verticeNova));
                    
                }else if(valor.Key == ConsoleKey.NumPad2 || valor.Key == ConsoleKey.D2)
                {

                    Vertice origem, destino;
                    
                    do
                    {
                        Console.WriteLine("Informe o Vertice Origem");

                        origem = grafo.RetornaVertice(Console.ReadLine());
                    } while (origem == null);

                    do
                    {
                        Console.WriteLine("Informe o Vertice Destino");
                        destino = grafo.RetornaVertice(Console.ReadLine());
                    } while (destino == null);
                        
                    Console.WriteLine("Informe a Distancia da Aresta");
                    int peso = int.Parse(Console.ReadLine());
                    Aresta arestaNova = new Aresta(origem, destino, peso);

                    grafo.AdicionarAresta(arestaNova);

                } 
                else if(valor.Key == ConsoleKey.NumPad3 || valor.Key == ConsoleKey.D3)
                {
                    Console.WriteLine("Informe o Vertice de Inicio");
                    grafo.EscolhendoMelhorCaminho(grafo.RetornaVertice(Console.ReadLine()));
                    
                }
                else if(valor.Key == ConsoleKey.NumPad4 || valor.Key == ConsoleKey.D4)
                {
                    Console.WriteLine("==================================================");
                    Console.WriteLine("=============LISTA DE ADJACENCIAS=================");
                    Console.WriteLine("==================================================");
                    grafo.MostraGrafo(grafo);
                    Console.ReadKey();
                }


                Console.Clear();

            } 

           
        }
    }
}
