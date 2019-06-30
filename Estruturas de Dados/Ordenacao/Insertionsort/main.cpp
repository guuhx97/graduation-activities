#include <cstdlib>
#include <iostream>

using namespace std;

void insertionsort(int vec[], int tam) {
  int i, j;
  int key;
 
  for (j = 1; j < tam; ++j) {
    key = vec[j];
    i = j - 1;
    while (vec[i] > key && i >= 0) {
      vec[i+1] = vec[i];
      --i;
    }
 
    vec[i+1] = key;
  }
}


int main(int argc, char *argv[])
{
    int vetor[5] = {9, 1, 3, 0, 99};
    insertionsort(vetor,5);    
    for (int i=0; i<5; i++){
        cout<<vetor[i]<<",";
    }
    
    system("PAUSE");
    return EXIT_SUCCESS;
}
