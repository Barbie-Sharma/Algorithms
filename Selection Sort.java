import java.util.Arrays;

class Selection {
    public static void main(String[] args){
        int[] array = {5, 4, 3, 2, 1};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    static void selectionSort(int[] array){
        for(int i = 0; i<array.length; i++){
            int last = array.length - i - 1;
            int maxIndex = getMaxIndex(array, 0, last);
            swap(array, maxIndex, last);
        }

    }

    static void swap(int[] array, int first, int second){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;

    }
    private static int getMaxIndex(int[] array, int start, int last) {
        int max = start;
        for(int i = start ; i<= last ; i++){
            if(array[max] < array[i]){
                max = i;
            }
        }
        return max;
    }
}
