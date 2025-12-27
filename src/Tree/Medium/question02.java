package Tree.Medium;

import java.util.*;

public class question02 {

    public TreeNode findSuccessor(TreeNode root, int key)
    {
        if (root == null) return  null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if (currentNode.val == key) {
                break;
            }
        }
        return queue.peek();
    }
    public List<List<Integer>> levelOrderTravels(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i=0; i<levelSize; i++){
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(0, currentLevel);
        }
        return result;
    }
//    public Node connect(Node root)
//    {
//        if (root == null) return null;
//        Node leftMost = root;
//        while (leftMost.left != null) {
//            Node current = leftMost;
//            while (current != null) {
//                current.left.next = current.right;
//                if (current.next != null){
//                    current.right.next = current.next.left;
//                }
//                current = current.next;
//            }
//            leftMost = leftMost.left;
//        }
//        return root;
//    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer((root));

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i=0; i<levelSize; i++){
                TreeNode currentNode = queue.poll();
                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }
                if (currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }

    boolean findPath(TreeNode root, int arr[]){
        if (root == null){
            return arr.length ==0;
        }
        return helper(root, arr, 0);
    }
    boolean helper(TreeNode node, int arr[], int index){
        if (node == null) {
            return false;
        }
        if (index >= arr.length || node.val != arr[index]) return false;
        if (node.left == null && node.right == null && index == arr.length-1) return true;
        return helper(node.left, arr, index+1) || helper(node.right, arr, index+1);
    }
    void dfsStack(TreeNode node){
        if (node == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode removed = stack.pop();
            System.out.print(removed.val + " ");
        }
    }
}
