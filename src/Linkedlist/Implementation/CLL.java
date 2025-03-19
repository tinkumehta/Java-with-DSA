package Linkedlist.Implementation;

public class CLL {
   private class Node {
        private int value;
        private Node next;

        Node(int value){
            this.value = value;
        }
    }

    private Node head;
   private Node tail;
   CLL() {
       this.head = null;
       this.tail = null;
   }

    public static void main(String[] args) {
        CLL l = new CLL();
        l.insert(5);
        l.insert(6);
        l.insert(7);
        l.insert(8);
        l.insert(9);
        l.insert(10);
        l.display();
        l.delete(10);
        l.display();
    }

    public void delete(int val)
    {
        Node node = head;
        if (node == null) {
            return;
        }
        if (head == tail) {
            head =null;
            tail = null;
            return;
        }
        if (node.value == val) {
            head = head.next;
            tail.next = head;
            return;
        }
        do {
            Node n = node.next;
            if (n.value == val) {
                node.next = n.next;
                break;
            }
            node = node.next;
        }while (node != head);
    }
    public void display()
    {
        Node node = head;
        if (head != null) {
            do {
                System.out.print(node.value + "->");
                if (node.next != null) {
                    node = node.next;
                }
            } while (node != head);
        }
        System.out.println("END");
    }
     public void insert(int val)
     {
         Node node = new Node(val);
         if (head == null) {
              head = node;
             tail = node;
             return;
         }
         tail.next = node;
         node.next = head;
         tail = node;
     }
}
