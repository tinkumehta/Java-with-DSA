package Stack.Implements;

public class customStack {
    protected int data[];
    int ptr =-1;
    private static final int  DEFAULT_SIZE = 10;
    customStack() {
        this(DEFAULT_SIZE);
    }
    customStack(int size){
        this.data = new int[size];
    }

    public static void main(String[] args) {
        customStack stack = new customStack();
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        System.out.println(stack.peek());
    }
    boolean isFull()
    {
        return ptr == data.length-1;
    }
    boolean isEmpty()
    {
        return ptr == -1;
    }
    int peek()
    {
        if (isEmpty()){
            System.out.println("Stack is empty");
        }
        return data[ptr];
    }
    int pop()
    {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        int removed = data[ptr];
        ptr--;
        return removed;
    }
    boolean push(int item)
    {
        if (isFull()) {
            System.out.println("Stack is full");
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

}
