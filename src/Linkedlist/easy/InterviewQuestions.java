package Linkedlist.easy;

public class InterviewQuestions {
    private class ListNode {
        int val;
        ListNode next;
        ListNode () {}
        ListNode(int x){
            val =x;
            next =null;
        }
    }

    public static void main(String[] args) {

    }
    public boolean isPalindrome(ListNode head)
    {
        ListNode mid = getMiddle(head);
        ListNode secondhead = reverselist(mid);
        ListNode reversehead = secondhead;


        while (head != null && secondhead != null) {
            if (head.val != secondhead.val) {
                break;
            }
            head = head.next;
            secondhead = secondhead.next;
            reverselist(reversehead);
        }
        return   head == null || secondhead == null;
    }
    public ListNode reverselist(ListNode head)
    {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;
        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }
    public ListNode reorderlist(ListNode head)
    {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMiddle(head);
        ListNode hs = reverselist(mid);
        ListNode hf = head;
        while (hf != null && hs != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hf = temp;
        }
        if (hf != null) {
            hf.next = null;
        }

        return head;
    }
    public ListNode getMiddle(ListNode head)
    {
        ListNode f = head;
        ListNode s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        return s;
    }
    public boolean isHappy(int num)
    {
        int f = num;
        int s = num;

        do {
            s = findSquare(s);
            f = findSquare(findSquare(f));
        } while (s !=f);
        if (s == 1)return true;
        return false;
    }
    private ListNode deleteCycle(ListNode head)
    {
        int length =0;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                length = lengthCycle(slow);
                break;
            }
        }
        if (length == 0) {
            return null;
        }
        ListNode f = head;
        ListNode s = head;
        if (length > 0) {
            s =s.next;
            length--;
        }
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;
    }
    private int findSquare(int number)
    {
        int ans =0;
        while (number > 0) {
            int rem = number % 10;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }
    public boolean hasCycle(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
    public int lengthCycle(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode temp = slow;
                int length =0;
                do{
                    temp = temp.next;
                    length++;
                }while (temp != slow);
                return length;
            }
        }
        return 0;
    }

}
