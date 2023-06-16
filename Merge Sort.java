import java.util.Arrays;

public class merge {

    private static void conquer(int[] array, int start, int mid, int end) {
        int[] merged = new int[end - start + 1];
        int index1 = start;
        int index2 = mid+1;

        int x = 0;

        while(index1 <= mid && index2 <= end){
            if(array[index1] <= array[index2]){
                merged[x++] = array[index1++];
            }else{
                merged[x++] = array[index2++];
            }
        }

        while(index1 <= mid){
            merged[x++] = array[index1++];
        }

        while(index2 <= end){
            merged[x++] = array[index2++];
        }

        for(int i = 0, j = start; i<merged.length; i++, j++){
                array[j] = merged[i]; 
        }
    }

    public static void divide(int[] array, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start + end)/2;
        divide(array, start, mid);
        divide(array, mid+1 , end);

        conquer(array, start, mid, end);
        

    }
    public static void main(String[] args){
        int[] array = {5, 4, 3, 2, 1};
        int n = array.length;
        divide(array, 0, n-1);
        System.out.println(Arrays.toString(array));
    }
}
