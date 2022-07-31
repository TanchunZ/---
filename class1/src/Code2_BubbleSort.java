import java.util.Arrays;
import java.util.Random;

public class Code2_BubbleSort {

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    public static int[] copyArray(int[] arr){
        int[] arr2 = new int[arr.length];
        if(arr == null){
            return null;
        }
        for (int i = 0; i <arr.length ; i++) {
            arr2[i] = arr[i];
        }
        return arr2;
    }


    public static int[] getRandomArray(int maxSize,int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxSize + 1) * Math.random()) - (int) ((maxSize + 1) * Math.random());
        }
        return arr;
    }

    public static boolean isEqual(int[] arr1,int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 != null && arr2 == null || arr1 == null && arr2 != null) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
    public static void printArray(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxSize = 10;
        int maxValue = 10;
        int times = 100;
        boolean flag = true;
        for (int i = 0; i < times; i++) {
            int[] arr1 = getRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            bubbleSort(arr1);
            Arrays.sort(arr2);

            if (!isEqual(arr1, arr2)) {
                printArray(arr1);
                printArray(arr2);
                flag = false;
                break;
            }
            flag = true;

        }

        if (flag == false) {
            System.out.println("what the fuck");
        } else {
            System.out.println("芜湖起飞");
        }
        int [] arr3 = getRandomArray(maxSize, maxValue);
        printArray(arr3);
        bubbleSort(arr3);
        printArray(arr3);
    }



}
