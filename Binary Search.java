public class binary {
    public static void main(String[] args){
        int[] array = {- 3, 0, 2, 3, 9, 12, 15};
        int answer = binarySearch(array, 15);
        System.out.println("Element at: " + answer);
    }

    static int binarySearch(int[] array, int target){
        int start = 0;
        int end = array.length - 1;

        while(start <= end){
            int mid = (start + end)/2;

            if(target < array[mid]){
                end = mid-1;
            }
            else if(target > array[mid]){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
