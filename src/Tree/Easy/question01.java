package Tree.Easy;

import java.util.ArrayList;
import java.util.List;

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
    static Node lca(Node root, int n1, int n2)
    {
        if (root == null) return null;
        if (root.data == n1 || root.data == n2) return root;
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);
        if (left != null && right != null) return root;
        return  (left != null) ? left : right;
    }
    static boolean isBSTUtil(Node node, int min, int max)
    {
        if (node == null) return true;
        if (node.data > min || node.data > max) return false;
        return isBSTUtil(node.left, min, node.data -1)
                 && isBSTUtil(node.right, node.data+1, max);
    }
    static boolean isBST(Node node)
    {
        return isBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {


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
