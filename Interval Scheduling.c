#include <stdio.h>
#include <stdlib.h>

struct Classes{
	int start;
	int finish;
};

struct Classes* list[10];
int i = -1;
int N = 0;

void swap(struct Classes *a, struct Classes *b) {
    struct Classes temp = *a;
    *a = *b;
    *b = temp;
}

void createClass(int a, int b){
	i++;
	struct Classes* c = (struct Classes*) malloc(sizeof(struct Classes));
	c->start = a;
	c->finish = b;

	list[i] = c;
	N++;
}

void heapify(int N, int a){
	int l = 2*a + 1;
	int r = 2*a + 2;
	struct Classes* largest = list[a];
	struct Classes* left = list[l];
	struct Classes* right = list[r];
		
	if(l<N && left->finish > largest->finish){
		largest = left;
	}
		
	if(r<N && right->finish > largest->finish){
		largest = right;
	}
	
	if(largest != list[a]){
		if(largest == left){
			swap(list[a], list[l]);
			heapify(N, l);
		}
		else{
			swap(list[a], list[r]);
			heapify(N, r);
		}
	}
}
	
void heapSort(){

	for(int b = N/2 -1; b>=0; b--){
		heapify(N, b);
	}
		
	for(int b = N-1; b>=0; b--){	
		swap(list[0], list[b]);
		heapify(b, 0);
	}

}

void print(){
	for(int k =0; k<10; k++){
		printf("%d-%d\n", list[k]->start, list[k]->finish);
	}

}

void printSchedule(){
	printf("Classes Scheduled: \n");
	int lastFinish = -1;

	for(int j=0; j<N; j++){
		if(list[j]->start >= lastFinish){
			printf("class of %d-%d\n", list[j]-> start, list[j]-> finish);
			lastFinish = list[j]-> finish;
		}
	}
}

int main(){
	
	createClass(0, 1);
	createClass(4, 9);
	createClass(2, 6);
	createClass(11, 12);
	createClass(1, 2);
	createClass(3, 5);
	createClass(1, 3);
	createClass(2, 3);
	createClass(7, 8);	
	createClass(10, 11);

	heapSort();

	printSchedule();

	return 0;
}

