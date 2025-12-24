package Tree.Implement;

public class SegmentTree {
    public static void main(String[] args) {
        int arr[] = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentTree tree = new SegmentTree(arr);
        // tree.display();
        System.out.println(tree.query(1, 6));
    }
    private static class Node {
        int data;
        int startinterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startinterval, int endInterval){
            this.startinterval = startinterval;
            this.endInterval = endInterval;
        }
    }
    Node root;
    public SegmentTree(int arr[]){
        this.root = constructTree(arr, 0, arr.length-1);
    }
    private  Node constructTree(int arr[], int start, int end){
        if (start == end){
            // leaf node
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        // create new node with index you are at
        Node node = new Node(start, end);
        int mid = start +(end -start) /2;
        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid+1, end);
        node.data = node.left.data + node.right.data;
        return node;
    }
    public void display(){
        display(this.root);
    }
    private void  display(Node node){
        String str ="";
        if (node.left != null) {
            str = str + "Interval=[" + node.left.startinterval + "-" + node.left.endInterval +"] and data: " + node.left.data + "=> ";
        } else {
            str = str + "No left child";
        }

        // for current node
    str = str + "Interval=[" + node.startinterval + "_" + node.endInterval + "] and data: " + node.data + " <= ";
        if (node.right != null){
            str = str + "Interval=[" + node.right.startinterval + "-" + node.right.endInterval +"] and data: " + node.right.data + "=> ";
        } else {
            str = str + "No right child";
        }

        System.out.println(str);

        // call recursion
        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }
    }
    // query
    public int query(int qsi, int qei){
        return  this.query(this.root, qsi, qei);
    }
    private int query(Node node , int qsi, int qei){
        // node is completely lying inside query
        if (node.startinterval >= qsi && node.endInterval <= qei){
            return node.data;
        } else if (node.startinterval > qei || node.endInterval < qsi) {
            return  0;
        } else {
            return  this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }
    // updated
    public void update(int index, int value){
        this.root.data = update(this.root, index, value);
    }
    private int update(Node node, int index, int value){
        if (index >= node.startinterval && index <= node.endInterval){
            if (index == node.startinterval && index <= node.endInterval){
                node.data = value;
                return node.data;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns +rightAns;
                return node.data;
            }
        }
        return node.data;
    }
}








