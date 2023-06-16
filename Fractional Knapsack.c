#include <stdio.h>
#include <stdlib.h>

struct Items{	
    float profit;
    float weight;    
};

struct PW{
	int id;
	float pw;
};

struct Items* items[3];
int n = 3;
int in = -1;
int W = 40;
float profit = 0;

struct PW* list[3];

void addItems(int a, int b){
    in++;
    struct Items* s = (struct Items*) malloc(sizeof(struct Items));
    s->profit = a;
    s->weight = b;

    items[in] = s;
}

void swap(struct PW *a, struct PW *b) {
    struct PW temp = *a;
    *a = *b;
    *b = temp;
}


void heapify(int N, int a){
	int l = 2*a + 1;
	int r = 2*a + 2;
	struct PW* largest = list[a];
	struct PW* left = list[l];
	struct PW* right = list[r];
		
	if(l<N && left->pw > largest->pw){
		largest = left;
	}
		
	if(r<N && right->pw > largest->pw){
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

	for(int b = n/2 -1; b>=0; b--){
		heapify(n, b);
	}
		
	for(int b = n-1; b>=0; b--){	
		swap(list[0], list[b]);
		heapify(b, 0);
	}

}


void findProfit(){
	for(int i = 0; i<n; i++){
		struct PW* p = (struct PW*) malloc(sizeof(struct PW));
		p->id = i;
   		p->pw = items[i]->profit/items[i]->weight;
		list[i] = p;
 	}

    heapSort();
  
	int j = 0;
	int in;
    for(j; j<n; j++){
   	    if(W> 0 && items[list[j]->id]-> weight<W){
   		    W = W - items[list[j]->id]-> weight;
   		    profit += items[list[j]->id]-> profit;
   		    int temp = ++j;
   		    in = list[temp]->id;
   	    }
   	    else{
   		    break;
   	    }
    }

	if(W>0){
   			profit += (float)(items[in]->profit)*(W/items[in]-> weight);
			W = 0;
   	 }
}

int main(){
    
    	addItems(60, 10);
    	addItems(100, 20);
    	addItems(120, 30);

    	findProfit(); 
   
    	printf("Profit acquired: %f", profit);

	for (int i = 0; i < n; i++) {
    		free(items[i]);
	}
	return 0;
}
