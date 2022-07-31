import java.util.Arrays;

public class Code4_BSExit {
    public static boolean bsExit(int[] arr,int num) {
        if (arr == null||arr.length==0) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        int M = 0;

        while (L < R) {
            M = L + ((R - L) >> 1);
            if (arr[M] == num) {
                return true;
            } else if (arr[M] > num) {
                R = M - 1;
            } else if (arr[M] < num) {
                L = M +1;
            }
        }
        return arr[L] == num;

    }
//  -9 -6 -4 -3 -2 -1 3 3 5
//   0  1  2  3  4  5 6 7 8
//   l           m        r
//                  l m   r
//                      l r
//                      m
//                        l
    public static boolean test(int[] arr, int num) {
        for (int m : arr
        ) {
            if (m == num) {
                return true;
            }

        }

        return false;
    }

    public static int[] getRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int)((maxSize+1)*Math.random())];
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = (int)((maxValue+1)*Math.random())-(int)((maxValue+1)*Math.random());
        }
        return arr;
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
        int times = 1000;
        boolean flag = true;
        int num = (int) ((maxValue + 1) * Math.random());
        for (int i = 0; i < times; i++) {
            int[] arr1 = getRandomArray(maxSize, maxValue);
            Arrays.sort(arr1);
            if (bsExit(arr1, num) != test(arr1, num)) {
                flag = false;
                printArray(arr1);
                System.out.println(num);
                System.out.println(bsExit(arr1,num));
                System.out.println(test(arr1,num));
                break;
            } else flag = true;

        }
        System.out.println( flag ? "nice" : "fuck");


    }

}
