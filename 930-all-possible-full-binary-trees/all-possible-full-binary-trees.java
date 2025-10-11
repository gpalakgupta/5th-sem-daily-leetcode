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
    HashMap<Integer,List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        if (n == 1) {
            TreeNode root = new TreeNode(0);
            List<TreeNode> res = new ArrayList<>();

            res.add(root);
            return res;
        }

        if(map.containsKey(n)){
            return map.get(n);
        }

        for (int i = 1; i < n; i+=2) {
            List<TreeNode> ll = allPossibleFBT(i);
            List<TreeNode> rr = allPossibleFBT(n - i - 1);
            for (TreeNode l : ll) {
                for (TreeNode r : rr) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }
        map.put(n,ans);
        return ans;
    }
}