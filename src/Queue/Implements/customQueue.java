package Queue.Implements;

public class customQueue  {
    int data[];
    int end =0;
    private static final int DEFAULT_SIZE = 10;
    customQueue() {
        this(DEFAULT_SIZE);
    }
    customQueue(int size){
        this.data = new int[size];
    }
    boolean isFull()
    {
        return end == data.length;
    }
    boolean isEmpty ()
    {
        return end == 0;
    }
    int front() throws Exception
    {
        if (isFull()) {
            throw new Exception("Queue is Empty");
        }
        return data[0];
    }
    int push(int item) throws Exception
    {
        if (isFull()) {
            throw new Exception("Queue is full");
        }
        return data[end++] = item;
    }
    int remove () throws Exception
    {
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }
        int removed = data[0];
        for (int i=1; i<end; i++){
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }
    void display()
    {
        for (int i=0; i<end; i++){
            System.out.print(data[i] + "->");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception{
        customQueue queue = new customQueue(10);
        queue.push(5);
        queue.push(6);
        queue.push(7);
        queue.push(7);
        queue.push(7);
        queue.push(7);
        queue.display();
        queue.remove();
        System.out.println(queue.front());
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
        queue.display();
    }
}










