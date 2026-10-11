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
    
    int preorderIdx = 0;
    Map<Integer, Integer> store = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            store.put(inorder[i], i);
        }

        return dfs(preorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int l, int r) {
        if (l > r) {
            return null;
        }
        int val = preorder[preorderIdx++];
        TreeNode root = new TreeNode(val);
        int mid = store.get(val);
        root.left = dfs(preorder, l, mid - 1);
        root.right = dfs(preorder, mid + 1, r);
        return root;
    }
}
/**
Questions:
1 <= inorder.length <= 2001
inorder.length == preorder.length
-1000 <= preorder[i], inorder[i] <= 1000

preorder = [1,2,3,4], inorder = [2,1,3,4]

[1,2,3,4]
 ^idx

 0 1 2 3
[2,1,3,4]
   ^i

[2]  [3,4]
[2:0,1:1,3:2,4:3]
                    1
                  /   \
                 2     3 
                        \
                         4

TC: O(n), SC: O(n)
*/