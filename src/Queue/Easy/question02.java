package Queue.Easy;

import java.util.Stack;

public class question02 {

    static class Queue {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        void enqueue(int x)
        {
            while (!st1.isEmpty()) {
                st2.push(st1.peek());
                st1.pop();
            }
            st1.push(x);
            while (!st2.isEmpty()) {
                st1.push(st2.peek());
                st2.pop();
            }
        }
        int dequeue()
        {
            if (st1.isEmpty()) return -1;
            int x = st1.peek();
            st1.pop();
            return x;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }

}
