import java.util.Arrays;

/**
 * 选择排序
 */
public class Code1_SelectionSort {

    public static void SelectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tmp = i;
            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[i]) {
//                    tmp = j;
//                }else {
//                    tmp = i;
//                }
                tmp = arr[j] < arr[i] ? j : i;
                swap(arr, tmp, i);
            }

        }
    }


    /**
     * 两数交换

     */
    private static void swap(int[] arr, int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 随机生成一个数组
     * @param maxSize 最大长度
     * @param maxValue 最大范围（-maxValue~maxValue）
     * @return
     */
    public static int[] getRandomArray(int maxSize,int maxValue) {
        //Math.random()  [0~1)
        //Math.random()*N  [0~N)
        //Math.random()*(N+1) [0~N]
        int[] arr = new int[(int) ((maxSize + 1)*Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((int) (Math.random() * (maxValue + 1))) - (int) (Math.random() * (maxValue));
        }
        return arr;
    }


    /**
     * 比较两个数组
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1,int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        if (arr1 != null && arr2 == null || arr1 == null && arr2 != null) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 拷贝一份数组
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        return arr2;
    }

    public static void printArray(int[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
        } else {
            System.out.println("数组为空！");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 100;
        int times = 10000;
        boolean flag = true;

        for (int i = 0; i < times; i++) {
            int[] arr1 = getRandomArray(maxSize, maxValue);
//            System.out.print("原arr1 ：  ");
//            printArray(arr1);
//            System.out.print("排序后arr1  : ");
            SelectionSort(arr1);
//            printArray(arr1);
            int[] arr2 = copyArray(arr1);
//            System.out.print("原arr2   :  ");
//            printArray(arr2);
//            System.out.print("排序后arr2  : ");
            Arrays.sort(arr2);
//            printArray(arr2);
            if (isEqual(arr1, arr2) != true) {
                flag = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
//            System.out.println("--------------------");
        }
        if (flag == true) {
            System.out.println("芜湖起飞");
        } else {
            System.out.println("what the fuck!");
        }
    }
}
