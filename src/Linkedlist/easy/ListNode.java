package Linkedlist.easy;

import java.util.HashMap;
import java.util.HashSet;

public class ListNode {
    int val;
    ListNode next;
    ListNode child;
    ListNode prev;
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
    static ListNode findFirstNode(ListNode head)
    {
        HashSet<ListNode> st = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (st.contains(curr)){
                return curr;
            }
            st.add(curr);
            curr = curr.next;
        }
        return  null;
    }
    public ListNode swapPairs(ListNode head)
    {
        if (head == null || head.next == null) return head;
        ListNode second = head.next;
        ListNode third = second.next;
        second.next = head;
        head.next = swapPairs(third);
        return second;
    }
    public ListNode rotateRight(ListNode head, int k)
    {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        ListNode last = head;
        int length =0;
        while (last.next != null) {
            last = last.next;
            length++;
        }
        last.next = head;
        int rotations = k % length;
        int skip = rotations -length;
        ListNode lastNext = head;
        for (int i=0; i<skip -1; i++){
            lastNext = lastNext.next;
        }
        head = lastNext.next;
        lastNext.next =null;
        return head;
    }
    public ListNode flatten(ListNode head)
    {
        ListNode temp = head;
        while (temp != null) {
            ListNode t = temp.next;
            if (temp.child != null) {
                ListNode c = flatten(temp.child);
                temp.next =c;
                c.prev =temp;
                while (c.next != null) {
                    c =c.next;
                }
                c.next = t;
                if (t != null) t.prev = c;
            }
            temp.child = null;
            temp =t;
        }
        return head;
    }
    public ListNode detectCycle(ListNode head)
    {
        HashMap<ListNode, Boolean> mt = new HashMap<>();
        while (head != null) {
            if (mt.containsKey(head)){
                return head;
            }
            mt.put(head, true);
            head = head.next;
        }
        return head;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        int total =0, carry =0;
        while (l1 != null || l2 != null || carry != 0) {
            total = carry;
            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }
            int num = total % 10;
            carry = total / 10;
            dummy.next = new ListNode(num);
            dummy =dummy.next;
        }
        return res.next;
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
