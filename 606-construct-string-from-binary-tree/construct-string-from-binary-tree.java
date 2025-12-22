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
    public String tree2str(TreeNode root) {
        return helper(root);
    }
    public String helper(TreeNode root){
        if(root == null){
            return "";
        }

        String ans = "";
        ans += root.val;
        if(root.left != null){
            ans += "("+helper(root.left)+")";
        }
        else if(root.right != null){
            ans += "()";
        }
        if(root.right != null){
            ans += "("+helper(root.right)+")";
        }
        return ans;
    }
}