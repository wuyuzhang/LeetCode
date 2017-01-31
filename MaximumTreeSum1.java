/**
 * Created by Yuzhang on 1/30/17.
 * from any Leaf Node to Leaf Node
 */


public class MaximumTreeSum1 {
    static class TreeNode {
        int key;
        TreeNode left, right;
        public TreeNode(int key) {
            this.key = key;
            left = right = null;
        }
    }

    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        if (root.left != null && root.right != null) {
            max[0] = Math.max(max[0], root.key + left + right);
            return Math.max(left, right) + root.key;
        }
        return root.left == null ? right + root.key : left + root.key;
    }

    TreeNode root;

    public static void main(String args[])
    {
        MaximumTreeSum1 tree = new MaximumTreeSum1();
        tree.root = new TreeNode(4);
        tree.root.left = null;
        tree.root.right = new TreeNode(5);


        int result = tree.maxPathSum(tree.root);
        System.out.println(result);
    }

}
