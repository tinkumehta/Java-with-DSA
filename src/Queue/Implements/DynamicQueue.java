package Queue.Implements;

public class DynamicQueue extends circularQueue{
    DynamicQueue() {
        super();
    }
    DynamicQueue(int size){
        super(size);
    }

    @Override
    int insert(int item) throws Exception {
        if (this.isFull()) {
            int temp [] = new int[data.length * 2];
            for (int i=0; i<data.length; i++){
                temp[i]= data[(front +1) % data.length];
            }
            front =0;
            end = data.length;
            data = temp;
        }
        return super.insert(item);
    }
}

