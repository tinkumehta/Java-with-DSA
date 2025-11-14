package Tree.Easy;

public class question02 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
     public boolean isSymmertic(TreeNode root){
        if (root == null) return true;
        return isSmmertich(root.left, root.right);
     }
     public boolean isSmmertich(TreeNode root, TreeNode node){
        if (root == null && node == null) {
          return root == node;
        }
        if (root.val != node.val) return false;
        return  isSmmertich(root.left, node.right) && isSmmertich(root.right, node.left);
     }
    // leetcode 111
        public static int min_depth(TreeNode root){
        if ( root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left== null){
          return  min_depth(root.right)+1;
        }
        if ( root.right == null){
            return min_depth(root.left)+1;
        }
        int left = min_depth(root.left)+1;
        int right = min_depth(root.right)+1;
        return Math.min(left, right);
        }

}
