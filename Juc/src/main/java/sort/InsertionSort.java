package sort;

import java.util.Arrays;

public class InsertionSort {
    /**
     * 直接插入排序在以下效率比较高:
     * 1.直接插入排序在基本有序时，效率较高
     * 2.在待排序的记录个数较少时，效率较高
     * @param args
     */
    public static void main(String[] args) {
       /* int[] arr = new int[]{9, 7, 5, 3, 1};
        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            int current = arr[i + 1];
            int preIndex = i;
            while ((preIndex >= 0) && current < arr[preIndex]) {
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;
        }
        System.out.println(Arrays.toString(arr));*/
        test2();
    }
    public static void test1(){
        int[] arr = new int[]{9, 7, 5, 3, 1};
        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            int current = arr[i+1];
            int preIndex = i;
            while (preIndex >= 0 && current < arr[preIndex]){
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void test2(){
        int[] arr = new int[]{9, 7, 5, 3, 1};
        int len = arr.length;
        int temp,gap = len /2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && temp <arr[preIndex]){
                    arr[preIndex+gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex+gap] = temp;
            }
            gap /=2;
        }
        System.out.println(Arrays.toString(arr));
    }
}
