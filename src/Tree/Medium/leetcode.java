package Tree.Medium;

import java.util.*;

public class leetcode {

    // leetcode 230
    int count =0;
    public int kthSmallest(TreeNode root, int k) {
        return kthSmall(root, k).val;
    }
    public TreeNode kthSmall(TreeNode root, int k){
        if (root == null) return root;
        TreeNode left = kthSmall(root.left, k);
        if (left != null){
            return left;
        }
        count++;
        if (count == k) {
            return root;
        }
        return kthSmall(root.right, k);
    }
    // leetcode 236
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if ( root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null || right != null) return root;
        return left == null ? right : left;
    }
    // leetcode 98
    public boolean validBST(TreeNode root, Integer low, Integer high){
        if (root == null) return false;
        if (low != null && root.val <= low) return false;
        if (high != null && root.val >= high) return false;
        boolean left = validBST(root, low, root.val);
        boolean right = validBST(root, root.val, high);
        return left && right;
    }
    // leetcode 114

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                // swap
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
    // leetcode 199
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i=0; i<n; i++){
                TreeNode currNode = queue.poll();
                if (i == n-1){
                    result.add(currNode.val);
                }
                if (currNode.left != null){
                    queue.offer(currNode.left);
                }
                if (currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
        }
        return result;
    }
    // leetcode 116
//    public Node sumOfLeaves(Node root){
//        if (root == null) return null;
//        Node currLeft = root;
//        while (currLeft.left != null){
//            Node current = currLeft;
//            while (current != null){
//                current.left.next = current.right;
//                if (current.next != null){
//                    current.right.next = current.next.left;
//                }
//                current = current.next;
//            }
//            currLeft = currLeft.left;
//        }
//        return root;
//    }
    // leetcode 103
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean reverse = false;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i=0; i<size; i++){

                if (!reverse){
                    TreeNode currentLevel = deque.pollFirst();
                    level.add(currentLevel.val);
                    if (currentLevel.left != null) {
                        deque.addLast(currentLevel.left);
                    }
                    if (currentLevel.right != null) {
                        deque.addLast(currentLevel.right);
                    }
                } else {
                    TreeNode currentLevel = deque.pollLast();
                    level.add(currentLevel.val);
                    if (currentLevel.right != null){
                        deque.addFirst(currentLevel.right);
                    }
                    if (currentLevel.left != null) {
                        deque.addFirst(currentLevel.left);
                    }
                }
            }
            reverse = !reverse;
            result.add(level);
        }
        return result;
    }
    // leetcode 637
    public List<Double> averageOfLevels(TreeNode root){
        List<Double> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            double averageSize =0;
            for (int i=0; i<n; i++){
                TreeNode currentLevel = queue.poll();
                averageSize += currentLevel.val;
                if (currentLevel.left != null) {
                    queue.offer(currentLevel.left);
                }
                if (currentLevel.right != null) {
                    queue.offer(currentLevel.right);
                }
            }
            averageSize = averageSize /n;
            result.add(averageSize);
        }
        return result;
    }
    // leetcode 102
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return  result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> currentSize = new ArrayList<>();
            for (int i=0; i<n; i++){
                TreeNode currLevel = queue.poll();
                currentSize.add(currLevel.val);
                if (currLevel.left != null) {
                    queue.offer(currLevel.left);
                }
                if (currLevel.right != null) {
                    queue.offer(currLevel.right);
                }
            }
            result.add(currentSize);
        }
        return result;
    }
    // leetcode 124
    int ans = Integer.MIN_VALUE;
    public int pathSum(TreeNode root){
      //  if (root == null) return 0;
        helper(root);
        return ans;
    }
    public int helper(TreeNode root){
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        left = Math.max(0, left);
        right = Math.max(0, right);
        int sum = left + right +root.val;
        ans = Math.max(ans, sum);
        return Math.max(left, right) + root.val;
    }
}
