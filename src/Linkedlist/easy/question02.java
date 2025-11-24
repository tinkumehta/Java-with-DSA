package Linkedlist.easy;

import Linkedlist.Implementation.LS;

public class question02 {
   private class ListNode {
      int val;
    private ListNode next;
     ListNode(int x) {
          val = x;
          next = null;
     }
  }
  public ListNode detectCycle(ListNode head){
       int length =0;
       ListNode slow = head;
       ListNode fast = head;
      while (fast != null && fast.next != null) {
          fast = fast.next.next;
          slow = slow.next;
          if (fast == slow) {
              length = lengthCycle(slow);
              break;
          }
      }
      if (length == 0){
          return null;
      }
      // find the start node
      ListNode f = head;
      ListNode s = head;

      while (length > 0) {
          s = s.next;
          length--;
      }
      // keep moving both forward and they will meet at cycle start
      while (f != s) {
          f = f.next;
          s = s.next;
      }
      return s;

  }
    public int lengthCycle(ListNode head) {
        ListNode fast = head;
       ListNode slow = head;
        while(fast != null &&fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                // calculate the length
                ListNode temp = slow;
                int length =0;
                do{
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }
//    private void bubbleSort(int row, int col){
//        if (row == 0) {
//            return;
//        }
//        if (col < row) {
//            Node first = get(col);
//            Node second = get(col+1);
//            if (first.value > second.value){
//                // swap
//                if (first == head){
//                    head = second;
//                    first.next = second.next;
//                    second.next = first;
//                } else if (second == tail){
//                    Node prev = get(col -1);
//                    prev.next = second;
//                    tail = first;
//                    first.next = null;
//                    second.next = tail;
//                } else {
//                    Node prev = get(col -1);
//                    prev.next = second;
//                    first.next = second.next;
//                    second.next = first;
//                }
//            }
//            bubbleSort(row, col+1);
//        } else {
//            bubbleSort(row -1, 0);
//        }
//    }
    // recursion reverse

}
