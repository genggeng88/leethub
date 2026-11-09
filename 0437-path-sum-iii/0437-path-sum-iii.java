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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int[] cnt = new int[]{0};
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        dfs(root, 0L, targetSum, map, cnt);
        return cnt[0];
    }

    private void dfs(TreeNode node, long prefixSum, int targetSum, Map<Long, Integer> map, int[] cnt) {
        if (node == null) return;
        prefixSum += node.val;
        cnt[0] += map.getOrDefault(prefixSum - targetSum, 0);

        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        dfs(node.left, prefixSum, targetSum, map, cnt);
        dfs(node.right, prefixSum, targetSum, map, cnt);
        
        map.put(prefixSum, map.get(prefixSum) - 1);
    }
}