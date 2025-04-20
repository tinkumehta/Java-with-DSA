package Tree.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (){}
    TreeNode (int val) {
        this.val = val;
    }
    TreeNode (int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    static int result =0;
    public int longestUnivaluePath(TreeNode root)
    {
        int ans = dfs(root);
        return Math.max(result, ans);
    }
    private int dfs(TreeNode root)
    {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (root.left != null) {
            if (root.left.val == root.val) {
                left++;
            }
        }
        if (root.right != null) {
            if (root.right.val == root.val) {
                right++;
            }
        }
        if (root.left != null && root.right != null) {
            if (root.val == root.left.val && root.val == root.right.val) {
                result = Math.max(result, left + right);
                return Math.max(left, right);
            }
        }
        result = Math.max(right, result);
        result = Math.max(left, result);
        if (root.left != null) {
            if (root.left.val == root.val) {
                return left;
            }
        }
        if (root.right != null) {
            if (root.right.val == root.val) {
                return right;
            }
        }
        return 0;
    }
    public boolean isValidSerialization(String preorder)
    {
        String nodes [] = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }

    static long levelSum [] = new long[1_000_001];
    static int maxLevel =0;
    public long kthLargestLevelSum(TreeNode root, int k)
    {
        traverse(root, 0);
        Arrays.sort(levelSum, 0, maxLevel);
        return (k > maxLevel) ? -1 : levelSum[maxLevel -k];
    }
    public void traverse(TreeNode node, int level)
    {
        if (node == null) return;
        if (level >= maxLevel)
            levelSum[maxLevel++] = node.val;
        else
            levelSum[level] += node.val;
        traverse(node.left , level+1);
        traverse(node.right, level +1);
    }

    Map<Long, Integer> hmap ;
    int count ;
    public int pathSum(TreeNode root, int targetSum)
    {
        hmap = new HashMap<>();
        count =0;
        dfs(root, 0, targetSum);
        return count;
    }
    public void dfs(TreeNode root, long perfix, int targetSum)
    {
        if (root == null) return;
        perfix += root.val;
        if (hmap.containsKey(perfix - targetSum)){
            count += hmap.get(perfix - targetSum);
        }
        if (targetSum == perfix) {
            count++;
        }
        hmap.put(perfix, hmap.getOrDefault(perfix , 0) +1);
        dfs(root.left, perfix, targetSum);
        dfs(root.right, perfix, targetSum);
        // backtacking
        hmap.put(perfix, hmap.get(perfix) -1);
    }
}









