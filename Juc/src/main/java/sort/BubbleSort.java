package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9,7,5,3,1};
        int len = arr.length;
        int temp = -1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len-1-i; j++) {
                if (arr[j+1]<arr[j]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
