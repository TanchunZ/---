public class Code01_DeleteGivenValue {
    static class Node {
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 单链表中删除某些值
     * @param head
     * @param num 要删除的数
     * @return
     */
    public static Node DeleteGivenValue(Node head, int num) {
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur.next != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 随机生成一个单链表。
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static Node getRandomLinkedList(int maxSize,int maxValue){
        int size = (int)((maxSize+1)*Math.random()+1);
        if(size ==0){
            return null;
        }
        Node head = new Node((int)((maxValue+1)*Math.random())-(int)((maxValue+1)*Math.random()));
        Node pre = head;
        size--;
        while (size!=0){
            Node cur = new Node((int)((maxValue+1)*Math.random())-(int)((maxValue+1)*Math.random()));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }

    public static void printLinkedList(Node head){
        if(head==null){
            System.out.println("null");
        }else {
            while (head.next != null) {
                System.out.print(head.value + " ");
                head = head.next;
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int maxSize = 10;
        int maxValue = 10;
        int times = 100;
        for (int i = 0; i < times; i++) {
            Node head = getRandomLinkedList(maxSize,maxValue);
            printLinkedList(head);
            int num = (int)((maxValue+1)*Math.random())-(int)((maxValue+1)*Math.random());
            System.out.println("要删除的数: "+5);
            Node newHead = DeleteGivenValue(head,5);
            printLinkedList(newHead);
            System.out.println("------------------------");
        }


    }

}
