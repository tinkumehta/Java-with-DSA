package Stack.Implements;

public class question01 {
    protected int data[];
    private static final  int DEFAULT_SIZE=10;
    int ptr =-1;

    public question01(int size) {
        this.data = new int[size];
    }
    question01 () {
        this(DEFAULT_SIZE);
    }
    boolean add(int val){
        if (isFull()){
            System.out.println("Stack is Full !!");
        }
        ptr++;
        data[ptr] = val;
        return true;
    }
    boolean isFull(){
        return ptr == data.length-1;
    }
    boolean isEmpty(){
        return ptr ==-1;
    }
    int peek() throws Exception{
        if (isEmpty()){
            throw new Exception("Stack is empty");
        }
        return data[ptr];
    }
    int pop() throws  Exception{
        if (isEmpty()) {
            throw new  Exception("Stack is Empty");
        }
        return data[ptr--];
    }


    public static void main(String[] args) throws Exception {
        question01 q = new question01();
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        System.out.println(q.isFull());
        System.out.println(q.pop());
        System.out.println(q.pop());
    }
}
