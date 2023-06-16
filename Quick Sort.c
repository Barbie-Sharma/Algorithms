#include <stdio.h>

void swap(int *x, int *y){
    int temp = *x;
    *x = *y;
    *y = temp;
}

int Partition(int array[], int p, int r){
    int x = array[r];
    int i = p - 1;
    for (int j = p; j <= (r-1); j++){
   	 if(array[j] <= x){
   		 i++;
   		 swap(&array[i], &array[j]);
   	 }
    }
    swap(&array[i+1], &array[r]);
    
    return i+1;
}

void QuickSort(int array[], int p, int r){
    if(p<r){
   	 int q = Partition(array, p, r);
   	 QuickSort(array, p, q-1);
   	 QuickSort(array, q+1, r);
    }    
}

int main(){
    int array[5] = {7, 2, 6, 0, 13};
    int p = 0;
    int r = 4;
    
    QuickSort(array, p, r);
    
    for(int j = 0; j < 5; j++){
   	 printf("%d ", array[j]);
    }
}

