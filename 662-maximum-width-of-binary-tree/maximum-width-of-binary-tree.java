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
    public class Pair {
        TreeNode node;
        int num;

        Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }

    }

    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            int n = q.size();
            int min = q.peek().num;
            int first = 0;
            int last = 0;
            for (int i = 0; i < n; i++) {
                Pair pr = q.poll();
                TreeNode node = pr.node;
                int num = pr.num;
                int curr = num-min;
                if (i == 0) {
                    first = curr;
                }
                if (i == n - 1) {
                    last = curr;
                }
                if (node.left != null) {
                    q.add(new Pair(node.left, 2 * curr + 1));
                }
                if (node.right != null) {
                    q.add(new Pair(node.right, 2 * curr + 2));
                }

            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}