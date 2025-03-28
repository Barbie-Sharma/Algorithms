import java.util.Arrays;

public class heap {

    public static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
    
    public static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2*i +1;
        int right = 2*i + 2;

        if(left<n && array[left] > array[largest]){
            largest = left;
        }

        if(right<n && array[right] > array[largest]){
            largest = right;
        }

        if(largest != i){
            swap(array, largest, i);
            heapify(array, n, largest);
        }
    }

    public static void heapSort(int[] array){
        int n = array.length;

        for(int i = n/2-1; i>= 0; i--){
            heapify(array, n, i);
        }
        for(int i = n-1; i>= 0; i--){
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    public static void main(String[] args){
        int[] array = {20, 543, 23, 1, 3, 7};
        heapSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
