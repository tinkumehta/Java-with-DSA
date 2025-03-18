package Linkedlist.Implementation;

public class LL {
    private class Node {
       private int value;
       private Node next;

       Node(){}
        Node(int value){
           this.value = value;
        }
        Node (int value, Node next){
           this.value = value;
           this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;


    public static void main(String[] args) {
        LL ll = new LL();
        ll.insertFirst(4);
        ll.insertFirst(5);
        ll.insertFirst(6);
        ll.insertFirst(7);
        ll.insertLast(9);
        ll.insertRec(10, 4);
        ll.display();
        ll.deleteFirst();
        ll.get(4);
      //  ll.deleteLast();
        ll.delete(3);
        ll.display();

    }
    public static LL merge(LL first, LL second)
    {
        Node f = first.head;
        Node s = second.head;
        LL ans = new LL();
        while (f != null && s != null) {
            if (f.value < s.value) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }
        while (f != null) {
            ans.insertLast(f.value);
            f = f.next;
        }
        while (s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }
        return ans;
    }
    public void duplicate()
    {
        Node node = head;
        while (node.next != null) {
            if (node.value == node.next.value){
                node.next  = node.next.next;
                size--;
            }else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    // =========  END
    public Node find(int value)
    {
        Node node = head;
        while (node != null) {
            if (node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public int delete(int index)
    {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node prev = get(index -1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }
    public int deleteLast()
    {
        if (size <= 1) {
            return deleteFirst();
        }
        Node secondLast = get(size -2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }
    public Node get(int index)
    {
        Node node = head;
        for (int i=0; i<index; i++){
            node = node.next;
        }
        return node;
    }
    public int deleteFirst()
    {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }
    public void insertFirst(int val)
    {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size +=1;
    }
    public void insertLast(int val)
    {
        if (tail == null){
            insertLast(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        node = tail;
        size++;
    }
    public void insert(int val, int index)
    {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (size == index) {
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i=1; i<index; i++){
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }
    public void insertRec(int val, int index)
    {
        head = insertRec(val, index, head);
    }
    public Node insertRec(int val, int index, Node node)
    {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = insertRec(val, index-1, node.next);
        return node;
    }
    public void display()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println();

    }


}
