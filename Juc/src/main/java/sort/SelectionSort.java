package sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9,7,5,3,1};
        int len = arr.length;
        int temp = -1;
        for (int i = 0; i < len-1; i++) {
            int minIndex = i;
            for (int j = i; j < len; j++) {
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
