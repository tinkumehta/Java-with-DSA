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

    }

    public ListNode sortList(ListNode head)
    {
        if (head != null && head.next != null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    ListNode getMid(ListNode head)
    {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
    ListNode merge(ListNode list1, ListNode list2)
    {
        ListNode dumyHead = new ListNode();
        ListNode tail = dumyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dumyHead.next;
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
