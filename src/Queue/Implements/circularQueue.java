package Queue.Implements;

public class circularQueue {
    int data[];
    private static final int  DEFAULT_SIZE = 10;
    circularQueue(){
        this(DEFAULT_SIZE);
    }
    circularQueue(int size){
        this.data = new int[size];
    }
    public int end = 0;
    public int front =0;
    public int size =0;

    boolean isFull()
    {
        return size == data.length;
    }
    boolean isEmpty()
    {
        return size ==0;
    }
    int front() throws Exception
    {
        if (isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[front];
    }
    int insert(int item) throws Exception
    {
        if (isFull()) {
           throw new Exception("Queue is Full");
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return end;
    }
    int remove() throws Exception
    {
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }
    void display()
    {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        }
        int i = front;
        do {
            System.out.print(data[i] + " ");
            i++;
            i %= data.length;
        } while (i != end);
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        circularQueue q = new circularQueue();
        System.out.println(q.isEmpty());
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);
        q.insert(6);
        q.display();
        q.remove();
        q.display();
        System.out.println(q.front());
        System.out.println(q.isFull());
    }
}
