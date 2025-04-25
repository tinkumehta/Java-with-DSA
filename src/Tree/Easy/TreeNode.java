package Tree.Easy;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    public static void main(String[] args) {

    }
    public boolean isValidBST(TreeNode root)
    {
        if (root == null) {
            return true;
        }else
            return helperisValidBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean helperisValidBst(TreeNode root, int min, int max)
    {
        if (root == null) return true;
        if ((root.val < min || root.val > max) ||
            root.val == Integer.MIN_VALUE && root.left != null ||
            root.val == Integer.MAX_VALUE && root.right != null
        ) {
            return false;
        }
        return helperisValidBst(root.left, min, root.val-1) &&
                helperisValidBst(root.right, root.val +1, max);
    }
    public int getMinimumDifference(TreeNode root)
    {
        int min = Integer.MAX_VALUE;
        int prev = Integer.MAX_VALUE;
        if (root == null) return  0;
        getMinimumDifference(root.left);
        min  = Math.min(min, Math.abs(root.val -prev));
        prev = root.val;
        getMinimumDifference(root.right);
        return min;
    }
    public int sumOfLeftLeaves(TreeNode root)
    {
        if (root == null) return 0;
        int sum =0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null)
                sum += root.left.val;
            else
                sum += sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
    public List<String> binaryTreePaths(TreeNode root)
    {
        List<String> res = new ArrayList<>();
        buildsPath(root, new StringBuilder(), res);
        return res;
    }
    public boolean buildsPath(TreeNode root, StringBuilder sb, List<String> list)
    {
        if (root == null)  return true;
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            list.add(sb.toString());
        }
        sb.append("->");
        buildsPath(root.left, sb, list);
        buildsPath(root.right, sb, list);
        sb.setLength(len);
        return false;
    }
    public TreeNode invertTree(TreeNode root)
    {
        if (root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        // swap
        root.right = left;
        root.left = right;
        return root;
    }
    public List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }
    public List<Integer> postOrder(TreeNode root, List<Integer> res)
    {
        if (root != null) {
            postOrder(root.left, res);
            postOrder(root.right, res);
            res.add(root.val);
        }
        return res;
    }
    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return  res;
    }
    public List<Integer> preOrder(TreeNode root, List<Integer> res)
    {
        if (root != null) {
            res.add(root.val);
            preOrder(root.left, res);
            preOrder(root.right, res);
        }
        return res;
    }
    public boolean hasPathSum(TreeNode root, int targetSum)
    {
        if (root == null) return false;
        if (root.val == targetSum && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right , targetSum - root.val);
    }
    public int minDepth(TreeNode root)
    {
        if (root == null) return 0;
        if (root.left == null){
            return minDepth(root.right) +1;
        }
        if (root.right == null) {
            return minDepth(root.left) +1;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int ld = minDepth(root.left) +1;
        int rd = minDepth(root.right) +1;
        return Math.min(ld, rd);
    }
    public boolean isBalanced(TreeNode root)
    {
        return height(root)  != -1;
    }
    public int height(TreeNode root)
    {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = height(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) >1) return  -1;
        return 1+ Math.max(leftHeight , rightHeight);
    }
    public TreeNode sortedArrayToBST(int[] nums)
    {
        return BST (nums, 0, nums.length-1);
    }
    public TreeNode BST(int nums[], int left, int right)
    {
        if (left > right) return null;
        int mid = (right +left) /2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = BST(nums, left, mid -1);
        root.right = BST(nums, mid +1, right);
        return root;
    }
    public boolean isSymmetric(TreeNode root)
    {
        return root == null || isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode root, TreeNode node)
    {
        if (root == null || node == null){
           return root == node;
        }
        if (root.val != node.val) return false;
        return isSymmetric(root.left, node.right) && isSymmetric(root.right, node.left);
    }
    public List<Integer> inorderTravels(TreeNode root)
    {

        List<Integer> res = new ArrayList<>();
        inorderTravels(root, res);
        return res;
    }
    public List<Integer> inorderTravels(TreeNode root, List<Integer> res)
    {
        if (root != null) {
            inorderTravels(root.left, res);
            res.add(root.val);
            inorderTravels(root.right, res);
        }
        return res;
    }

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

}
