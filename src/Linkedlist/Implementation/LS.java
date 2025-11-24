package Linkedlist.Implementation;

;

public class LS {
    // LS = LinkedList singly
    private Node head;
    private Node tail;
    private int size;
    public LS(){
        this.size = 0;
    }
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
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size +=1;
    }
    public void display() {
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public void insertLast(int val){
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }
    private Node insertRec(int val, int index, Node node){
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return  temp;
        }
        node.next = insertRec(val, index--, node.next);
        return node;
    }
    public int hasCycle(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast != null &&fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
               // calculate the length
                Node temp = slow;
                int length =0;
                do{
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }
    private void reverse(Node node){
        if (node == tail){
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }
}







