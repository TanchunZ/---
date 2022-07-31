import java.util.Arrays;


/**
 * 找出一个有序数组中最左边的大于等于k值的位置。
 */
public class Code05_BSNearLeft {
    public static int BSNearLeft(int[] arr ,int num) {
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        while (L <= R) {
           int  M = L + ((R - L) >> 1);
            if (arr[M] >= num) {
                index = M;
                R = M - 1;

            } else {
                L = M + 1;


            }

        }
        return index;
//   -2   -2   0   2   4   4   5   5   7   9         -2
//   0    1    2   3   4   5   6   7   8   9
// i  l                m                   r
//   l    m        r   i
//   lr    i
   //m


    }

    public static int[] getRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int)((maxSize+1)*Math.random())];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = (int)((maxValue+1)*Math.random())-(int)((maxValue+1)*Math.random());
        }
        return arr;

    }

    public static int test(int[] arr,int num){
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]>=num){
                return i;
            }
        }
        return -1;
    }

    public static void println(int[] arr){
        for (int n: arr
             ) {
            System.out.print(n+" ");
        }
        System.out.println(" ");
    }


    public static void main(String[] args) {
        int maxSize = 10;
        int maxValue = 10;
        int times = 1000;
        boolean flag = true;

        for (int i = 0; i < times; i++) {
            int num = (int) ((maxValue + 1) * Math.random())-(int) ((maxValue + 1) * Math.random());
            int[] arr1 = getRandomArray(maxSize, maxValue);
            Arrays.sort(arr1);
            int r = BSNearLeft(arr1, num);
            int r2 = test(arr1, num);
            if (r != r2) {
                flag = false;
                println(arr1);
                System.out.println(num);
                System.out.println(r);
                System.out.println(r2);
                break;
            }
        }

        System.out.println(flag ? "nice" : "fuck");
        int num2 = (int) ((maxValue + 1) * Math.random());
        int[] arr2 = getRandomArray(maxSize, maxValue);
        Arrays.sort(arr2);
        println(arr2);
        System.out.println(num2);
        System.out.println(BSNearLeft(arr2, num2));


    }

}
