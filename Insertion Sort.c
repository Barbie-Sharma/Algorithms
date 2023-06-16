#include <stdio.h>

void printArray(int a[]){
	for(int k = 0; k<5; k++){
		printf("%d ", a[k]);
	}
}

int main(){
	int i , j, num;
	int array[5];
	printf("Enter 5 numbers: ");
	for(i = 0; i<5; i++){
		scanf("%d", &array[i]);
	}
	for(j = 1; j<5; j++){
		num = array[j];
		i = j -1;
		while(i >= 0 && (num < array[i])){
			array[i+1] = array[i];
			i = i - 1;
		}
		array[i + 1] = num;	
	}
	printArray(array);
	return 0;
}
