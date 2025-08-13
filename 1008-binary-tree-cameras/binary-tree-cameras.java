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
    int camera = 0;
    public int minCameraCover(TreeNode root) {
        int c = helper(root);
        if(c == -1){
            camera++;
        }
        return camera;
    }
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if(left == -1 || right == -1){
            camera++;
            return 1;
        }
        else if(left == 1 || right == 1){
            return 0;
        }
        else{
            return -1;
        }
    }
}