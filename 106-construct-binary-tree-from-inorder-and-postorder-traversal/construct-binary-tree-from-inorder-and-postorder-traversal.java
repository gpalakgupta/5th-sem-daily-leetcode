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
    public int search(int[] in, int si, int end, int item){
        for(int i = si; i<=end; i++){
            if(in[i] == item){
                return i;
            }
        }
        return 0;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return createTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    public TreeNode createTree(int[] in, int[] post, int ilo, int ihi, int plo, int phi){
        if(ilo>ihi || plo>phi){
            return null;
        }
        TreeNode root = new TreeNode(post[phi]);
        int idx = search(in,ilo,ihi,post[phi]);
        int nel = idx-ilo;
        root.left = createTree(in,post,ilo,idx-1,plo,plo+nel-1);
        root.right = createTree(in,post,idx+1,ihi,plo+nel,phi-1);
        return root;
    }
}