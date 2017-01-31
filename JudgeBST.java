/**
 * Created by Yuzhang on 1/30/17.
 */

public class JudgeBST {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int item) {
            data = item;
            left = right = null;
        }
    }

    TreeNode root;

    boolean isBST(TreeNode node) {
        return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.data <= min || node.data >= max) {
            return false;
        }
        return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
    }

    public static void main(String args[]) {
        JudgeBST tree = new JudgeBST();
        tree.root = new TreeNode(4);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(3);

        if (tree.isBST(tree.root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}
