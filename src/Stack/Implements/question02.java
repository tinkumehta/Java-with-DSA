package Stack.Implements;

public class question02  extends question01{
    question02(){super();};
    question02 (int size){
        super(size);
    }

    @Override
    boolean add(int val) {
        if (isFull()) {
            int temp []= new int[data.length*2];
            for (int i=0; i<data.length; i++){
                temp[i] = data[i];
            }
            data = temp;
        }
        return super.add(val);
    }
}
