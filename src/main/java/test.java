public class test {


    public static void main(String[] args) {

        //Math.random()  [0~1)
        //Math.random()*N  [0~N)
        //Math.random()*(N+1) [0~N]
        int maxSize = 10;
        int maxValue = 10;
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((int) (Math.random() * (maxValue + 1))) - (int) (Math.random() * (maxValue));
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

//        int maxSize = 10;
//        int maxValue = 10;
//        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = ((int) ((maxValue + 1)*Math.random())) - ((int) ((maxValue)*Math.random())) ;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]);
//        }
//        System.out.println((int) Math.random());
//       int a = (int) Math.random() * (maxValue + 1);
//        System.out.println(a);
    }
}
