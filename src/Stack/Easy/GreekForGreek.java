package Stack.Easy;
import java.util.*;

public class GreekForGreek {

    public static void main(String[] args) {

    }

    public void deleteMid(Stack<Integer> s, int sizeOfStack)
    {
        int mid = (int) Math.floor((sizeOfStack +1) /2);
        if (s.size() == mid) {
            s.pop();
            return;
        }
        Stack<Integer> st  = new Stack<>();
        while (s.size() >= mid) {
            st.push(s.pop());

        }
        s.pop();
        while (st.size() > 0) {
            s.push(st.pop());
        }
    }
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k)
    {
        Stack<Integer> st = new Stack<>();
        for (int i=0; i<k ; i++){
            st.push(q.peek());
            q.remove();
        }
        for (int i=0; i<k; i++){
            q.add(st.peek());
            st.pop();
        }
        int n = q.size();
        for (int i=0; i<n- k; i++){
            int element = q.peek();
            q.add(element);
            q.remove();
        }
        return q;
    }
}
