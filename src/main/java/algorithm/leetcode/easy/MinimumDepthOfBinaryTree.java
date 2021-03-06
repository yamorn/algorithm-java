package algorithm.leetcode.easy;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Reference: <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/description/">Minimum Depth of Binary Tree</a>
 * Difficulty: Easy
 *
 * @author hufeng
 * @version MinimumDepthOfBinaryTree.java, v 0.1 21/11/2017 12:25 AM Exp $
 */

public class MinimumDepthOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static int minDepth = Integer.MAX_VALUE;

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        postOrderTraverse(root, 1, (root.left == null && root.right == null));
        return minDepth;
    }

    private static void postOrderTraverse(TreeNode node, int depth, boolean isLeaf) {
        if (node == null) {
            return;
        }
        if (isLeaf) {
            minDepth = Math.min(minDepth, depth);
        }
        postOrderTraverse(node.left, depth + 1, (node.left != null && node.left.left == null && node.left.right == null));
        postOrderTraverse(node.right, depth + 1, (node.right != null && node.right.left == null && node.right.right == null));
    }

    // Good solution
    public static int minDepthMethod2(TreeNode root) {
        if (root == null) return 0;
        int left = minDepthMethod2(root.left);
        int right = minDepthMethod2(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

}
