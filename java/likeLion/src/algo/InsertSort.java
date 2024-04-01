package algo;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[] {523, 6, 34, 245, 56, 21, 523, 36, 5476};

        insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for(int i =1;i<n;i++){
            int j = i-1;
            int tmp = arr[i];
            while(j>=0 && arr[j] > tmp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = tmp;
        }
    }

}
