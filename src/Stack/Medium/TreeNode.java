package Stack.Medium;

import java.util.Stack;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.data = val;
        left = right = null;
    }

    static boolean checkTreeIsBST(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.peek();
            stack.pop();
            if (prev != null && root.data <= prev.data) {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(8);

        if (checkTreeIsBST(root)) {
            System.out.print("YES");
        }
        else {
            System.out.print("NO");
        }
    }
}
