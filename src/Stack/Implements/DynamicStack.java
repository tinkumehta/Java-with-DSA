package Stack.Implements;

public class DynamicStack extends customStack{
    DynamicStack(){
        super();
    }
    DynamicStack(int size){
        super(size);
    }

    @Override
    boolean push(int item)
    {
        if (this.isFull()) {
            int temp[] = new int[data.length *2];
            for (int i=0; i<data.length; i++){
                temp[i] = data[i];
            }
            data = temp;
        }
        return super.push(item);
    }
}
