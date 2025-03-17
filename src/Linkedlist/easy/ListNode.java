package Linkedlist.easy;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode (int val){
        this.val = val;
    }
    ListNode (int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(0, new ListNode(1)));
        ListNode m = new ListNode(1, new ListNode(1, new ListNode(1)));
        System.out.println(getDecimalValue(head1));
        System.out.println(getDecimalValue(m));
    }


    public static int getDecimalValue(ListNode head) {
        int sum =0;
        while (head != null) {      // if value is 1-0-1
            sum = sum *2 + head.val; // 0 *2 + 1
            head = head.next;
        }
        return sum;
    }
}
