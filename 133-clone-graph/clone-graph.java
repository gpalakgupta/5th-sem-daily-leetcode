/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Node copy = new Node(node.val);
        Node[] vis = new Node[101];
        Arrays.fill(vis,null);
        dfs(node,copy,vis);
        return copy;
    }
    public void dfs(Node node, Node copy, Node[] vis){
        vis[copy.val] = copy;
        for(Node nbrs : node.neighbors){
            if(vis[nbrs.val] == null){
                Node nn = new Node(nbrs.val);
                copy.neighbors.add(nn);
                dfs(nbrs,nn,vis);
            }
            else{
                copy.neighbors.add(vis[nbrs.val]);
            }
        }
    }
}