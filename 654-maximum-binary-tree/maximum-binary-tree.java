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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int[] nums, int st, int end){
        if(st > end){
            return null;
        }
        int idx = mx(nums,st,end);
        TreeNode root = new TreeNode(nums[idx]);
        root.left = helper(nums,st,idx-1);
        root.right = helper(nums,idx+1,end);
        return root;
    }
    public int mx(int[] nums, int st, int end){
        int idx = st;
        for(int i = st+1; i<=end; i++){
            if(nums[idx] < nums[i]){
                idx = i;
            }
        }
        return idx;
    }
}