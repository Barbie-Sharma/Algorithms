import java.util.Arrays;

class Bubble{
    //Sinking sort or Exchange sort
    public static void main(String[] args){
        //3 1 5 4 2
        //1 3 5 4 2
        //1 3 5 4 2
        //1 3 4 5 2
        //1 3 4 2 5
        int[] array = {5, 4, 3, 2, 1};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    static void bubbleSort(int[] array){
        for(int i = 0; i< array.length; i++){
            for(int j = 1; j < array.length - i; j++){
                if(array[j]< array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }

    }
}
