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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), results);
        return results;
    }

    public void dfs(TreeNode root, int targetSum, List<Integer> tmp, List<List<Integer>> results) {
        if (root == null) return;
        tmp.add(root.val);
        if(root.left == null && root.right == null && root.val == targetSum) {
            results.add(new ArrayList<>(tmp));
        } else {
            dfs(root.left, targetSum - root.val, tmp, results);
            dfs(root.right, targetSum - root.val, tmp, results);
        }
        tmp.remove(tmp.size() - 1);
    }

}