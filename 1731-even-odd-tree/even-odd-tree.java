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
    public boolean isEvenOddTree(TreeNode root) {
        return isvalid(root);
    }
    public boolean isvalid(TreeNode root){
        if(root == null){
            return true;
        }
        int idx = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            int prev = (idx % 2 == 0) ? 0 : 10000000;
            for(int i = 0; i<n; i++){
                TreeNode rv = q.poll();
                if(idx % 2 == 0 && (rv.val % 2 == 0 || rv.val <= prev)){
                    return false;
                }
                if(idx % 2 == 1 && (rv.val % 2 == 1 || rv.val >= prev)){
                    return false;
                }
                prev = rv.val;
                if(rv.left != null){
                    q.add(rv.left);
                }
                if(rv.right != null){
                    q.add(rv.right);
                }
            }
            idx++;
        }
        return true;
    }
}