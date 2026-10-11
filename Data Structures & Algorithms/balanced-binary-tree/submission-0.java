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
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{1,0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        boolean balance = left[0] == 1 && right[0] == 1 && Math.abs(left[1] - right[1]) <= 1;
        int h = 1 + Math.max(left[1], right[1]);

        return new int[]{balance ? 1 : 0, h};
    }
}
/**
Questions:
range the number of node? [0,1000]
val? -1000 <= val <= 1000
postorder
            |1 - 3| = 2 <= 1 
              t 1 f = f
               / \
              2 2 3 0 -> f 
                 /
              1 4 0 -> t
               /
              5 

1 + max(leftH, rightH)
[t,2]

leftH
rightH

TC: O(n), SC: O(n)
*/