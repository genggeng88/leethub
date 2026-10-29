/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        long[] prev = new long[]{Long.MIN_VALUE};
        return helper(root, prev);
    }

    private boolean helper(TreeNode root, long[] prev) {
        if (root == null) return true;
        if (!helper(root.left, prev)) return false;
        if (root.val <= prev[0]) return false;
        prev[0] = root.val; 
        if (!helper(root.right, prev)) return false;
        return true;
    }
}