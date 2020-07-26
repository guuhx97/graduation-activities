#include <cstdlib>
#include <iostream>

using namespace std;

const int MAX = 200000L;

void bubblesort (int a[MAX]){
     for(int j= MAX-1; j>0; j--){
         for(int i=0;i<j;i++){
             if(a[i+1] < a[i]){ 
                 int aux = a[i];
                 a[i] = a[i+1];
                 a[i+1] = aux; 
                 
             }
         }
     }
}


int main(int argc, char *argv[])
{
    int vetor[MAX];
    
    srand(time(NULL));
    
    for (int i=0; i<MAX; i++){
        vetor[i] = rand()%10000;
    }
    
    
    time_t a = time(NULL);
    

    bubblesort(vetor);
    
    for (int i=0; i<MAX; i++){
        cout<<vetor[i]<<"\n";
    }

//    system("PAUSE");    
        time_t b = time(NULL);    
        cout<<"\n\n"<<b-a<<" seg.\n\n";
    system("PAUSE");
    return EXIT_SUCCESS;
}
