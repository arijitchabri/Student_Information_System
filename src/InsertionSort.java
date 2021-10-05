public class InsertionSort {

    public static void insertionSort(int []arr, int element){
        int i = 0;
        int len = arr.length - 1;
        while(arr[i] < element){
            i++;
        }
        while(len > i){
            arr[len + 1] = arr[len];
            len--;
        }
        arr[i] = element;
    }

    public static void main(String[] args) {
        int []arr = {1, 2, 3, 4, 5};
        insertionSort(arr, 3);
        Test.print(arr);
    }
}
