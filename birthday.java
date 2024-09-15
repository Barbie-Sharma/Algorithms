import java.util.Map;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

class Food {
    int index;
    int quantity;
    int cost;

    public Food(int a, int b, int c) {
        index = a;
        quantity = b;
        cost = c;
    }
}

class Decor {
    int index;
    int quantity;
    int cost;

    public Decor(int a, int b, int c) {
        index = a;
        quantity = b;
        cost = c;
    }
}

class Heap {
    public static void swap(Map[] array, int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
    
    public static void heapify(Map[] array, int n, int i) {
        int largest = i;
        int left = 2*i +1;
        int right = 2*i + 2;

        if(left<n && array[get(left)] > array[get(largest)]){
            largest = left;
        }

        if(right<n && array[get(right)] > array[get(largest)]){
            largest = right;
        }

        if(largest != i){
            swap(array, largest, i);
            heapify(array, n, largest);
        }
    }

    public static void heapSort(Map[] array){
        int n = array.length;

        for(int i = n/2-1; i>= 0; i--){
            heapify(array, n, i);
        }
        for(int i = n-1; i>= 0; i--){
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }
}

public class birthday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int b = scanner.nextInt(); // Budget

        int n = scanner.nextInt(); // Number of food items
        Food[] food = new Food[n];
        for (int i = 0; i < n; i++) {
            int quantity = scanner.nextInt();
            int cost = scanner.nextInt();
            food[i] = new Food(i, quantity, cost);
        }

        int m = scanner.nextInt(); // Number of decor items
        Decor[] decor = new Decor[m];
        for (int i = 0; i < m; i++) {
            int quantity = scanner.nextInt();
            int rate = scanner.nextInt();
            decor[i] = new Decor(i, quantity, rate);
        }

        Map<int, int> foodQC[n] = new HashMap<int, int>();
        for (int i = 0; i < n; i++) {
            int quantity = food[i].quantity;
            int cost = food[i].cost;
            foodQC.put(i, quantity/cost);
        }

        Map<int, int> decorQC[n] = new HashMap<int, int>();
        for (int i = 0; i < n; i++) {
            int quantity = decor[i].quantity;
            int cost = decor[i].cost;
            decorQC.put(i, quantity/cost);
        }


        Heap.heapSort(foodQC);
        Heap.heapSort(decorQC);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            // ...
        }

        while (foodIndex < n && food[foodIndex].cost <= b) {
            maxFood += food[foodIndex].quantity;
            b -= food[foodIndex].cost;
            foodIndex++;
        }

        while (decorIndex < m && decor[decorIndex].rate <= b) {
            maxDecor += decor[decorIndex].quantity;
            b -= decor[decorIndex].rate;
            decorIndex++;
        }

        System.out.println(maxFood + " " + maxDecor);
    }
}

