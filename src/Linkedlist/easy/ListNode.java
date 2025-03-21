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
    public ListNode swapNodes(ListNode head, int k)
    {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode fast = head;
        ListNode slow = head;
        for (int i=0; i<k; i++){
            fast = fast.next;
        }
        ListNode node1 = fast;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode node2 = slow.next;
        // swap
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
        return node.next;
    }
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        int lenght = findLength(head);
        int i=0 , st = lenght- n -1;
        ListNode curr = head;
        if (st == -1) return head;
        while (i < st) {
            curr = curr.next;
            i++;
        }
        curr.next = curr.next.next;
        return head;
    }
    public int findLength(ListNode head)
    {
        int count =0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr= curr.next;
        }
        return count;
    }
    public ListNode removeElements(ListNode head, int val)
    {
        ListNode temp = new ListNode(0), curr = temp;
        temp.next = head;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return temp.next;
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
