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
    int count = 0;
    int val = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return val;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        dfs(root.left, k);
        count++;
        if (count == k) {
            val = root.val;
        }
        dfs(root.right, k);
    }
}
/**
Questions:
1 <= k <= the number of nodes in the tree <= 10,000
0 <= node.val <= 10,000

                2
              /  \
             1    3

*/