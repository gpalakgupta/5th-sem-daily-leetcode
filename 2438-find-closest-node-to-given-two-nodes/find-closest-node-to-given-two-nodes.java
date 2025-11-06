class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        
        Arrays.fill(dist1,Integer.MAX_VALUE);
        Arrays.fill(dist2,Integer.MAX_VALUE);
        dist1[node1] = 0;
        dist2[node2] = 0;

        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];
        visited1[node1] = true;
        visited2[node2] = true;


        dfs(edges,node1,dist1,visited1);
        dfs(edges,node2,dist2,visited2);

        int min = -1;
        int dismin = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            int mx = Math.max(dist1[i],dist2[i]);
            if(dismin > mx){
                dismin = mx;
                min = i;
            }
        }
        return min;
    }
    public void dfs(int[] edges, int node, int[] dist, boolean[] vis){
        vis[node] = true;
        int u = edges[node];
        if(u != -1 && (!vis[u])){
            dist[u] = 1+dist[node];
            dfs(edges,u,dist,vis);
        }
    }
}