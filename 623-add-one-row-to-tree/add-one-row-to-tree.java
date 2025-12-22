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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode nn = new TreeNode(val);
            nn.left = root;
            return nn;
        }
        return helper(root,val,depth,1);
    }
    public TreeNode helper(TreeNode root, int val, int depth, int curr){
        if(root == null){
            return null;
        }

        if(curr == depth-1){
            TreeNode lefttemp = root.left;
            TreeNode righttemp = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);

            root.left.left = lefttemp;
            root.right.right = righttemp;
            return root;
        }

        root.left = helper(root.left,val,depth,curr+1);
        root.right = helper(root.right,val,depth,curr+1);
        return root;
    }
}