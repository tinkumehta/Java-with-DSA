package Tree.Medium;
 /*
    Convert Binary Tree to Doubly Linked List by keeping track of visited node
    Given a Binary Tree, The task is to convert it to a Doubly Linked List keeping the same order.

    The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL.
    The order of nodes in DLL must be the same as in Inorder for the given Binary Tree.
    The first node of Inorder traversal (leftmost node in BT) must be the head node of the DLL.
  */
    class Node {
        int data;
        Node left, right;
        Node (int data){
            this.data = data;
            left = right = null;
        }
 }

public class question01 {
    Node root;
    Node head;
    static Node prev = null;
    void doublyLinkedList(Node root)
    {
        if (root == null) return;
        doublyLinkedList(root.left);
        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
         prev = root;
         doublyLinkedList(root.right);
    }
    void printlist(Node val)
    {
        while (val != null) {
            System.out.print(val.data + " ");
            val = val.right;

        }
    }

    public static void main(String[] args) {
        question01 tree = new question01();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);
        tree.doublyLinkedList(tree.root);
        tree.printlist(tree.head);
    }
}

