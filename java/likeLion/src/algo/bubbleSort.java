package algo;

import java.util.Arrays;
import java.util.List;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {34,35,6734,3,635,24,543};

        for (int i = 0; i < arr.length -1 ; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {
                if(arr[j] > arr[i+1]){
                    int temp  = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));


    }
}
