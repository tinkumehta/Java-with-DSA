package Tree.Easy;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    public static void main(String[] args) {

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
