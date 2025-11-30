package Linkedlist.easy;

public class question03 {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    private Node head;
    private Node tail;
    private int size =0;

    public question03() {
        this.size =0;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size +=1;
    }
    public void insertLast (int val){
        if (tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }
    public int size(){
        return size;
    }
    public void display(){
        Node node = head;
        while (node != null) {
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.println("END");
    }
    public Node insertRec(int val, int index, Node node){
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = insertRec(val, index--, node);
        return node;
    }
    public void reverse(Node node){
        if (node == tail) {
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    public int hasCycle(Node node){
        Node f = node;
        Node s = node;
        while (f != null && f.next != null){
            f = f.next.next;
            s = s.next;
            if (f == s) {
                Node temp = s;
                int length =0;
                do {
                    temp = temp.next;
                    length++;
                } while (s != temp);
                return length;
            }
        }
            return 0;

    }
    public static void main(String[] args) {
        question03 q = new question03();
        q.insertFirst(5);
        q.insertFirst(4);
        q.insertFirst(3);
        q.insertFirst(2);
        q.insertLast(1);
   //     q.insertRec(10, 2, )
        q.display();
        System.out.println(q.size());
    }
}
