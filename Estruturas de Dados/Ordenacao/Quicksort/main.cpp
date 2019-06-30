#include <cstdlib>
#include <iostream>

using namespace std;

 
int partition(int vec[], int left, int right) {
  int i, j;
 
  i = left;
  for (j = left + 1; j <= right; ++j) {
    if (vec[j] < vec[left]) {
      ++i;
      int aux = vec[i];
      vec[i] = vec[j];
      vec[j] = aux;
    }
  }
  int aux = vec[left];
  vec[left] = vec[i];
  vec[i] = aux;

 
  return i;
}
 
void quicksort(int vec[], int left, int right) {
  int r;
 
  if (right > left) {
    r = partition(vec, left, right);
    quicksort(vec, left, r - 1);
    quicksort(vec, r + 1, right);
  }
}


int main(int argc, char *argv[])
{
    int vetor[] = {9, 7, 0, 1, 2};
    quicksort(vetor, 0, 4);
    for (int i=0; i<5; i++){
        cout<<vetor[i]<<",";
    }
    system("PAUSE");
    return EXIT_SUCCESS;
}
