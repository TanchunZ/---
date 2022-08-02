/**
 * 用数组实现队列
 */
public class Code02_RingArray {
    public static class MyQueue {
        int[] arr;
        private int pullI; //出队列的位置
        private int pushI; //进队列的位置
        private int size;  //目前队列长度
        private final int limit; //生成的数组长度

        public MyQueue(int limit) {
            arr = new int[limit];
            pullI = 0;
            pushI = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int num) {
            if (size == limit) {
                System.out.println("队列已满。");
            } else {
                size++;
                arr[pushI] = num;
                pushI = indexI(pushI);
            }
        }

        public int pull() {
            if (size == 0) {
                System.out.println("队列已空");
                return 0;
            } else {
                size--;
                int tmp = arr[pullI];
                pullI = indexI(pullI);
                return tmp;
            }

        }
        public  int indexI(int i){
            return i == limit-1 ? 0 : i++;
        }
    }
}