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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        inorder(root1,l1);
        inorder(root2,l2);
        List<Integer> ll = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < l1.size() && j < l2.size()){
            if(l1.get(i) < l2.get(j)){
                ll.add(l1.get(i));
                i++;
            }
            else{
                ll.add(l2.get(j));
                j++;
            }
        }
        while(i < l1.size()){
            ll.add(l1.get(i));
            i++;
        }
        while(j < l2.size()){
            ll.add(l2.get(j));
            j++;
        }
        return ll;
    }
    public void inorder(TreeNode root, List<Integer> ll){
        if(root == null){
            return;
        }
        inorder(root.left,ll);
        ll.add(root.val);
        inorder(root.right,ll);
    }
}