public class Code06 {
//    3   2   4   -1   -6   4   8   9
//    0   1   2    3    4   5   6   7
//    l            m                r
//    l                 l   m       r
//                      l
//

    public static int code6(int[] arr ) {
        if (arr.length == 0 || arr == null) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if(arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
            int l = 0;
            int r = arr.length - 2;
            int m = 0;
            while (l < r) {
                m = (l + r) / 2;
                if (arr[m] > arr[m - 1]) {
                    r = m - 1;
                } else if(arr[m]>arr[m+1]){
                    l = m + 1;
                }else {
                    return m;
                }
            }
            return l;

    }

    public static int[] getRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int)((maxSize*Math.random())+1)];
        arr[0] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
        for (int i = 1; i < arr.length; i++) {
            do {
                arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
            } while (arr[i] == arr [i-1]);
        }
        return arr;
    }

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static boolean isRight(int[] arr,int num){
        if(arr.length <= 1){
            return true;
        }
         if(num == 0){
            return arr[num]<arr[num+1];
        }
         if(num == arr.length-1){
            return arr[num] < arr[num-1];
        }else return arr[num]<arr[num-1]&&arr[num]<arr[num+1];
    }

    public static void main(String[] args) {
        int maxSize = 10;
        int maxValue = 10;
        int times = 100;
        for (int i = 0; i < times; i++) {
            int[] arr = getRandomArray(maxSize,maxValue);
            int r = code6(arr);
            if(!isRight(arr,r)){
                printArray(arr);
                System.out.println(r);
                System.out.println("fuck");
                break;
            }
        }
        int[] arr2 = getRandomArray(maxSize,maxValue);
        int r2 = code6(arr2);
        printArray(arr2);
        System.out.println(r2);
        System.out.println("结束");
    }

//    public static void main(String[] args) {
//        int[] arr = new int[]{7,-2,-6,-1,3,1};
//        int r = code6(arr);
//        System.out.println(r);
//
//    }
}
