package Linkedlist.Implementation;

public class DLL {
    private class Node {
        Node next;
        Node prev;
        int val;
        Node(int val){
            this.val = val;
        }
        Node (int val, Node next, Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
    Node head;

    public static void main(String[] args) {
        DLL l = new DLL();
        l.insertFirst(5);
        l.insertFirst(6);
        l.insertFirst(7);
        l.insertLast(11);
        l.insertFirst(8);
        l.insertFirst(9);
        l.display();
        l.insertLast(12);
        l.insertLast(13);
        l.insert(8, 74);
        l.display();
    }

    public Node find(int value)
    {
        Node node = head;
        while (node != null) {
            if (node.val == value) {
                return node;
            }
            node= node.next;
        }
        return null;
    }
    public void insert(int after, int val)
    {
        Node p = find(after);
        if (p == null) {
            System.out.println("Not exist");
            return;
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null) {
            node.next.prev = node;
        }
    }
    public void insertFirst(int val)
    {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }
    public void insertLast(int val)
    {
        Node node = new Node(val);
        Node last = head;
        node.next = null;
        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.prev = last;
    }
    public void display()
    {
        Node node = head;
        Node tail = null;
        while (node != null) {
            System.out.print(node.val + "->");
            tail = node;
            node = node.next;
        }
        System.out.println("END");
//        System.out.println("Reverse ");
//        while (tail != null) {
//            System.out.print(tail.val + "->");
//            tail = tail.prev;
//        }
//        System.out.println("START");
    }
}
