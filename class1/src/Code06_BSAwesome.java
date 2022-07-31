public class Code06_BSAwesome {

    /**
     * 找到一个随机数组中符合 局部最小 的位置
     * k 满足左边相邻的数比 k 大， 右边相邻的数也比 k 大； 即 k 局部最小。
     *
     * @return
     */
    public static int getLessIndex(int[] arr) {
//        int L = 0;
//        int R = arr.length - 2;
//        int M = 0;
//        if(arr==null||arr.length<=1){
//            return -1;
//        }
//        if (arr[0] < arr[1]) {
//            return 0;
//        }
//        if (arr[R] < arr[R - 1]) {
//            return R;
//        }
//        while (L < R) {
//            M = L + (R - L) >> 1;
//            if (arr[M] >= arr[M - 1]) {
//                R = M - 1;
//            } else {
//                L = M + 1;
//            }
//
//        }
//        return M;
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        } else {
            int left = 1;
            int right = arr.length - 2;
            int mid = 0;
            while (left < right) {
                mid = (left + right) / 2;
                if (arr[mid] > arr[mid - 1]) {
                    right = mid - 1;
                } else if (arr[mid] > arr[mid + 1]) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
            return left;
        }
    }
//    3  0  -4               6   -8   -3   -2   2   4   8
//    m  lr        0    1    2    3   4   5   6
//
//                   l    m   r
//                        l
//
//
//
//
//    public static int test(int[] arr) {
//        if (arr[0] < arr[1]) {
//            return 0;
//        }
//        if (arr.length - 1 < arr.length - 2) {
//            return arr.length - 1;
//        } else {
//            int num = -1;
//            for (int i = 1; i < arr.length - 2; i++) {
//                if (arr[i - 1] < arr[i] && arr[i] < arr[i + 1]) {
//                    num = i;
//                }
//            }
//            return num;
//
//        }
//    }

    public static boolean isRight(int[] arr,int num){
        if(arr.length<=1){
            return true;
        }
        if(num==0){
            return arr[0]<arr[1];
        }
        if(num==arr.length-1){
            return arr[num]<arr[num-1];
        }
        return arr[num]<arr[num-1]&&arr[num]<arr[num+1];

    }

    public static int[] getArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize) * Math.random()+1)];
        arr[0] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        for (int i = 1; i < arr.length - 1; i++) {
            do{
                arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
            } while (arr[i]==arr[i-1]);

        }
        return arr;

    }


    public static void println(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxSize = 10;
        int maxValue = 10;
        int times = 1000;

        for (int i = 0; i < times; i++) {
            int[] arr = getArray(maxSize, maxValue);
            int r = getLessIndex(arr);
            if(!isRight(arr,r)){
                println(arr);
                System.out.println(r+"fuck");
                break;
            }



        }

        System.out.println("结束");

    }

}
