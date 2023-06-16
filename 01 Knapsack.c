#include <stdio.h>

int max(int a, int b){
	return (a > b) ? a : b;
}

int Knapsack(int W, int w[], int p[]){
	int tabulation[5][W+1];
	int i, j; 
		
	for(j = 0; j<=W; j++){
		tabulation[0][j] = 0;
	}
	
	for(i = 1; i <=4; i++){
		for(j = 0; j<=W; j++){
			if(w[i-1] <= j){
				int temp = max(tabulation[i-1][j], (p[i-1] + tabulation[i-1][j-w[i-1]]));
				tabulation[i][j] = temp;	
			}
			else{
				tabulation[i][j] = tabulation[i-1][j];
			}
		}
	}
	return tabulation[4][W];
}

int main(){

	int W;
	int w[] = {3, 2, 4, 1};
	int p[] ={100, 20, 60, 40};

	printf("Weight of knapsack?");
	scanf("%d", &W);
	
	printf("Max profit obtained is: %d", Knapsack(W, w, p));
}
