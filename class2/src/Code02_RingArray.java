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
                throw new RuntimeException("队列已满！");
            } else {
                size++;
                arr[pushI] = num;
                pushI = indexI(pushI);
            }
        }

        public int pull() {
            if (size == 0) {
                throw new RuntimeException("队列已空！");
            } else {
                size--;
                int tmp = arr[pullI];
                pullI = indexI(pullI);
                return tmp;
            }

        }
        public int indexI(int limit){
            return limit < limit-1 ? limit+1 : 0;
        }
    }

    public static void main(String[] args) {
        MyQueue mq = new MyQueue(5);
        mq.push(1);
        mq.push(2);
        mq.push(3);
        mq.push(4);
        for (int i = 0; i <= mq.size; i++) {
            System.out.print(mq.arr[i]+" ");
        }
        System.out.println("--------");
        mq.pull();
        for (int i = 0; i <= mq.size; i++) {
            System.out.print(mq.arr[i]+" ");
        }
        System.out.println("--------");
        mq.pull();
        for (int i = 0; i <= mq.size; i++) {
            System.out.print(mq.arr[i]+" ");
        }
        System.out.println("--------");
        mq.push(5);
        mq.push(6);
        mq.push(7);
        for (int i = 0; i <= mq.size; i++) {
            System.out.print(mq.arr[i]+" ");
        }
    }
}