import java.util.Arrays;

public class Code3_InsertionSort {
    public static void insertionSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        for (int i = 1; i < arr.length ; i++) {
            for (int j = i-1; j >= 0 &&arr[j]>arr[j+1] ; j--) {
                swap(arr,j,j+1);
            }

        }
    }
//  1 2 3 4 5 1 2

     private static void swap(int[] arr, int i, int j) {
         int tmp = arr[i];
         arr[i] = arr[j];
         arr[j] = tmp;
    }

    public static int[] getRandomArray(int maxSize,int maxValue){
         int[] arr = new int[(int)((maxSize+1)*Math.random())];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = (int)((maxValue+1)*Math.random())-(int)((maxValue+1)*Math.random());
        }
        return arr;
    }
    public static int[] copyArray(int[] arr){
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        return arr2;
    }

    public static boolean isEqual(int[] arr1,int[] arr2){
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
        for (int i = 0; i < times ; i++) {
            int[] arr1 = getRandomArray(maxSize,maxValue);
            int[] arr2 = copyArray(arr1);
            insertionSort(arr1);
            Arrays.sort(arr2);
            if(!isEqual(arr1,arr2)){
                flag = false;
                printArray(arr1);
                printArray(arr2);
                break;

            }
        }
        System.out.println( flag  ? "芜湖起飞" : "what the fuck");

        int[] arr = getRandomArray(maxSize,maxValue);
        printArray(arr);
        insertionSort(arr);
        printArray(arr);
    }
}
