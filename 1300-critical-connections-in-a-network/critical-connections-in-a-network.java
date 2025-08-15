class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < connections.size(); i++) {
            int a = connections.get(i).get(0);
            int b = connections.get(i).get(1);
            map.get(a).add(b);
            map.get(b).add(a);
        }
        int[] vis = new int[n];
        int[] low = new int[n];
        int[] tin = new int[n]; // time of insetion
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, -1, vis, low, tin, map, ans);
        return ans;
    }

    int timer = 1;

    public void dfs(int node, int parent, int[] vis, int[] low, int[] tin, HashMap<Integer, List<Integer>> map,
            List<List<Integer>> ans) {
                vis[node] = 1;
                low[node] = tin[node] = timer;
                timer++;
                for(int nbrs : map.get(node)){
                    if(nbrs == parent){
                        continue;
                    }
                    if(vis[nbrs] == 0){
                        dfs(nbrs,node,vis,low,tin,map,ans);
                        low[node] = Math.min(low[node],low[nbrs]);
                        if(low[nbrs] > tin[node]){
                            ans.add(Arrays.asList(node,nbrs));
                        }
                    }
                    else{
                        low[node] = Math.min(low[node],low[nbrs]);
                    }
                }
    }
}