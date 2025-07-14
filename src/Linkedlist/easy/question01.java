package Linkedlist.easy;


class Node {
    int data;
    Node next;
    public Node(int val) {
        data = val;
        next = null;
    }
}
public class question01 {
    static Node reverseLinkedList(Node head , int m, int n)
    {
        Node curr = head, prevNode =null;
        int i;
        for ( i=1; i<m; i++){
            prevNode = curr;
            curr = curr.next;
        }
       Node revHead = curr;
        Node  revtail =null;
       Node nextNode;
        while (i <= n) {
            nextNode = curr.next;
            curr.next = revtail;
            revtail = curr;
            curr = nextNode;
            i++;
        }
        if (prevNode != null) {
            prevNode.next = revtail;
        } else {
            head = revtail;
        }
        revHead.next = curr;
        return head;
    }
    static void printList(Node head)
    {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("NULL ");
    }

    // different question
    static Node inserPoint(Node head1, Node head2)
    {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                if (temp == head2) {
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }
    public static void main(String[] args) {
       Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        head.next.next.next.next.next.next = new Node(70);
        System.out.println("Original List");
        printList(head);
        System.out.println("Modified List");
        head = reverseLinkedList(head, 3, 6);
        printList(head);
    }
}
