package Generics;

import java.util.Arrays;

public class CustomGenArrayList <T>{
    private Object [] data;
    private static int DEFAULT_SIZE =10;
    private int size =0; // also working in ind value

    public CustomGenArrayList() {
        data = new Object[DEFAULT_SIZE];
    }

    public void add(T num){
        if (isFull()){
            resize();
        }
        data[size++] = num;
    }
    private void resize() {
        Object[] temp = new Object[data.length*2];
        for (int i=0; i<data.length; i++){
            temp[i] = data[i];
        }
        data = temp;
    }
    private boolean isFull() {
        return  size == data.length;
    }
    public T remove(){
        T removed = (T) data[--size];
        return removed;
    }
    public T get(int index){
        return (T) data[index];
    }
    public int size(){
        return size;
    }
    public void set(int index, T value){
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomGenArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        CustomGenArrayList<Integer> list = new CustomGenArrayList<>();
        list.add(445);
        list.add(44);
        list.add(4);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isFull());
        CustomGenArrayList<String> s = new CustomGenArrayList<>();
        s.add("tin");
        s.add("tink");
        s.add("tinku");
        System.out.println(s);
    }
}
