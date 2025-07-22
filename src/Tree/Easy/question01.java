package Tree.Easy;

public class question01 {
    Node root;
    Node head;
   static Node prev = null;

  void BTree2DLinkedList (Node root)
  {
      if (root == null) return;
      BTree2DLinkedList(root.left);
      if (prev == null)
          head = root;
      else {
          root.left = prev;
          prev.right = root;
      }
      prev = root;
      BTree2DLinkedList(root.right);
  }
  void BTree2DCircular(Node root)
  {
      BTree2DLinkedList(root);
      prev.right = head;
      head.left = prev;
  }
  void printlist(Node node)
  {
      if (head == null) return;
      Node curr = node;
      do {
          System.out.print(curr.data + " ");
          curr = curr.right;
      } while (curr != node);
  }

    public static void main(String[] args) {
        question01 tree = new question01();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);
        tree.BTree2DCircular(tree.root);
        tree.printlist(tree.head);
    }
}

class Node {
    int data;
    Node left, right;
    Node(int data)
    {
        this.data = data;
        left =right =null;
    }
}
