package Tree.Hard;
import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class question01 {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(0);
        root.right = new Node(0);
        System.out.println(distributeCandy(root));

    }
    static int distributeCandyUtil(Node root, int[] ans)
    {
        if (root == null) return 0;
        int l = distributeCandyUtil(root.left, ans);
        int r = distributeCandyUtil(root.right, ans);
        ans[0] += Math.abs(l) + Math.abs(r) ;
        return root.data + l + r -1;
    }
    static int distributeCandy(Node root)
    {
        int ans [] = new int[1];
        distributeCandyUtil(root, ans);
        return ans[0];
    }
    void levelOrderRec(Node root, int level, List<List<Integer>> res)
    {
        if (root == null) return;
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.data);
        levelOrderRec(root.left, level+1, res);
        levelOrderRec(root.right, level +1, res);
    }
    List<List<Integer>> levelOrder(Node root)
    {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderRec(root, 0, res);
        return res;
    }
}

