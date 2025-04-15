package Tree.Medium;

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
}









