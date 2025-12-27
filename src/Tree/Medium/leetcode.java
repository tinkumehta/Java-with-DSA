package Tree.Medium;

import java.util.*;

public class leetcode {

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
