package Linkedlist.medium;

public class cloneRandom {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;
        System.out.println("Original linked list :");
        printlist(head);
        Node cloned = clonedLinkedlist(head);
        System.out.println("cloned linked list");
        printlist(cloned);
    }

    static void printlist(Node head)
    {
        while (head != null) {
            System.out.print(head.data + "(");
            if (head.random != null){
                System.out.print(head.random.data + "");
            } else {
                System.out.println("null");
            }
            System.out.print(")");
            if (head.next != null) {
                System.out.print("->");
            }
            head = head.next;
        }
        System.out.println();
    }
    static Node clonedLinkedlist(Node head)
    {
        if (head == null) return null;
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        // set a random pointer
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        // separte the node to cloned
        curr = head;
        Node cloneHead = head;
        Node clone = cloneHead;
        while (clone.next != null) {
            curr.next = curr.next.next;
            clone.next = clone.next.next;
            curr = curr.next;
            clone = clone.next;
        }
        curr.next = null;
        clone.next = null;
        return cloneHead;
    }


}
    class Node{
    int data;
    Node next, random;
    Node(int x){
        this.data = x;
        next = random =null;
    }
}