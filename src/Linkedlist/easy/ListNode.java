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
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4, new ListNode(5)))));
        ListNode m = new ListNode(1, new ListNode(1, new ListNode(1)));
        ListNode reverse = reverseList(head1);
        while (reverse != null){
            System.out.print(reverse.val + " ");
            reverse = reverse.next;
        }
        System.out.println();
    }


    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode temp = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
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
