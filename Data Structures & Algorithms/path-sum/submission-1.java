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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return leafPath(root, targetSum, 0);
    }

    private boolean leafPath(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return false;
        }
        sum += root.val;
        if (root.left == null && root.right == null && sum == targetSum) {
            return true;
        }
        if (leafPath(root.left, targetSum, sum)) {
            return true;
        }
        if (leafPath(root.right, targetSum, sum)) {
            return true;
        }
        sum -= root.val;
        return false;
    }
}
/**
Questions:
0 <= the number of nodes in the tree <= 5000
-1000 <= val <= 1000
-1000 <= targetSum <= 1000

TC: O(n), SC: O(n)
*/