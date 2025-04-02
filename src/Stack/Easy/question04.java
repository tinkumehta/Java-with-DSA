package Stack.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class question04 {
    Queue<Integer> q = new LinkedList<>();
    void push(int x)
    {
        int size = q.size();
        q.add(x);
        for (int i=0; i<size; i++){
            int y = q.remove();
            q.add(y);
        }
    }
    int pop()
    {
        if (q.isEmpty()) return -1;
        return q.remove();
    }
    int top()
    {
        if (q.isEmpty()) return -1;
        return q.peek();
    }
    boolean isEmpty()
    {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        question04 s = new question04();
        s.push(10);
        s.push(20);
        System.out.println(s.top());
        s.pop();
        s.push(30);
        s.pop();
        System.out.println(s.top());
        System.out.println(s.isEmpty());
    }
}
