package Queue.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class question01 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Tinku");
        queue.add("Muskan");
        queue.add("sona");
        queue.add("shilpi");
        queue.add("keytri");
        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.offer("Radhe"));
        System.out.println(queue);
        System.out.println(queue.element() );
        System.out.println(queue.contains("Muskan"));
        System.out.println(queue.isEmpty());
    }
}
