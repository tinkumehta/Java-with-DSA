package Queue.Implements;

import java.util.Stack;

public class MinStack {
    Stack<Long> st = new Stack<>();
    long min = -1;
    MinStack (){}
    void push(int item)
    {
        long x = (long) item;
        if (st.size() == 0){
            st.push(x);
             min =x;
        } else if (x >= min) {
            st.push(x);
        } else if (x <= min) {
            st.push(2 *x - min);
            min = x;
        }
    }
    void pop()
    {
        if (st.size() ==0) return;
        if (st.peek() > min){
            st.pop();
        } else if (st.peek() < min) {
            long old = 2 * min -st.peek();
            min = old;
            st.pop();
        }
    }
    int top()
    {
        if (st.size() ==0) return -1;
        long q = st.peek();
        if (q >= min){
            return (int) q;
        } else if (q <= min) {
            return (int) min;
        }
        return 0;
    }
    int getmin()
    {
        if (st.size() ==0)return 1;
        return (int) min;
    }
}
