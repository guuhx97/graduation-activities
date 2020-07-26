#include <cstdlib>
#include <iostream>

using namespace std;

void selectionsort(int vetor[],int tam) {
   int i, j;
   int min, aux;
   for(i=0; i<tam-1; i++) {
      min = i;
      aux = vetor[i];
      for(j=i+1; j<tam; j++) {
        if (vetor[j] < aux)
        {
           min=j;
           aux=vetor[j];
        }
      }
      aux = vetor[i];
      vetor[i] = vetor[min];
      vetor[min] = aux;
   }
}


int main(int argc, char *argv[])
{

 
    int vetor[5] = {9, 1, 3, 0, 99};
    selectionsort(vetor, 5);    
    for (int i=0; i<5; i++){
        cout<<vetor[i]<<",";
    }
    
    system("PAUSE");
    return EXIT_SUCCESS;
}
