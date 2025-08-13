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
    int ans = 0;
    public int distributeCoins(TreeNode root) {
          helper(root);
          return ans;
    }
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = helper(root.left);
        int r = helper(root.right);
        ans+= Math.abs(l)+Math.abs(r);
        return root.val+l+r-1;
    }
}