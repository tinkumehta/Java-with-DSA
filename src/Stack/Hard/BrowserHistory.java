package Stack.Hard;

    class Node {
        String data;
        Node prev ,next ;
        Node (String x){
            data = x;
            prev = null;
            next = null;
        }
    }

public class BrowserHistory {
    private Node curr;
    BrowserHistory(String home){
        curr = new Node(home);
    }

    public void visit(String url)
    {
        Node urlNode = new Node(url);
        urlNode.prev = curr;
        curr.next = urlNode;
        curr = urlNode;
    }
    String back(int step)
    {
        Node trav = curr;
        while (trav.prev != null && step > 0) {
            trav = trav.prev;
            step--;
        }
        curr = trav;
        return curr.data;
    }
    String forward (int step)
    {
        Node trav = curr;
        while (trav.next != null && step > 0) {
            trav = trav.next;
            step--;
        }
        curr = trav;
        return curr.data;
    }

    public static void main(String[] args) {
        String home = "muskan.com";
        BrowserHistory obj = new BrowserHistory(home);

        String url = "google.com";
        obj.visit(url);
        url = "youth.com";
        obj.visit(url);
        url = "facebook.com";
        obj.visit(url);

        System.out.println(obj.back(1));

        System.out.println(obj.back(1));

        System.out.println(obj.forward(1));

        obj.visit("linkedin.com");

        System.out.println(obj.forward(2));

        System.out.println(obj.back(2));

        System.out.println(obj.back(7));
    }
}
