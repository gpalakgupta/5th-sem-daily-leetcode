class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> lt = new ArrayList<>();
        lt.add(0);
        helper(graph,0,lt,ans);
        return ans;
    }
    public void helper(int[][] graph, int src, List<Integer> lt, List<List<Integer>> ans){
        if(src == graph.length-1){
            ans.add(new ArrayList<>(lt));
            return;
        }
        for(int nbrs : graph[src]){
            lt.add(nbrs);
            helper(graph,nbrs,lt,ans);
            lt.remove(lt.size()-1);
        }
    }
}