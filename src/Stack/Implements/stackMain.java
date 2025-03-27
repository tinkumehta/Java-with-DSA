package Stack.Implements;

public class stackMain {
    public static void main(String[] args) {
        customStack st = new DynamicStack(5);
        st.push(5);
        st.push(6);
        st.push(7);
        st.push(8);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}
