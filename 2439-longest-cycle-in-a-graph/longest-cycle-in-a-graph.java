class Solution {
    int res;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] vis = new int[n];
        int[] recs = new int[n];
        int[] count = new int[n];
        Arrays.fill(count,1);
        res = -1;
        for(int i = 0; i<n; i++){
            if(vis[i] == 0){
                dfs(i,vis,recs,count,edges);
            }
        }
        return res;
    }
    public void dfs(int node, int[] vis, int[] recs, int[] count, int[] edges){
        if(node != -1){
            vis[node] = 1;
            recs[node] = 1;
            int u = edges[node];
            if(u != -1 && (vis[u] != 1)){
                count[u] = 1+count[node];
                
                dfs(u,vis,recs,count,edges);
            }
            else if(u != -1 && (recs[u] == 1)){
                // System.out.print(u+" ");
                // System.out.println(count[u]);
                // System.out.print(node+" ");
                // System.out.println(count[node]);
                res = Math.max(res,count[node]-count[u]+1);
            }
            recs[node] = 0;
        }
    }
}