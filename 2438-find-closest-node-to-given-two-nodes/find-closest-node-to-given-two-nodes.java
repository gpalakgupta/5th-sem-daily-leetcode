class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1,Integer.MAX_VALUE);
        Arrays.fill(dist2,Integer.MAX_VALUE);

        dist1[node1] = 0;
        dist2[node2] = 0;

        // boolean[] visited1 = new boolean[n];
        // boolean[] visited2 = new boolean[n];

        // visited1[node1] = true;
        // visited2[node2] = true;

        // dfs(edges,dist1,node1,visited1);
        // dfs(edges,dist2,node2,visited2);


        bfs(edges,dist1,node1);
        bfs(edges,dist2,node2);


        int min = -1;
        int mindes = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            int mx = Math.max(dist1[i],dist2[i]);
            if(mindes > mx){
                mindes = mx;
                min = i;
            }
        }
        return min;
    }
    public void dfs(int[] edges, int[] dis, int node, boolean[] vis){
        vis[node] = true;
        int u = edges[node];
        if(u != -1 && (!vis[u])){
            dis[u] = 1+dis[node];
            dfs(edges,dis,u,vis);
        }
    }

    public void bfs(int[] edges, int[] dis, int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        boolean[] vis = new boolean[dis.length];
        vis[node]= true;
        while(!q.isEmpty()){
            int u = q.poll();
            int v = edges[u];
            if(v != -1 && (!vis[v])){
                dis[v] = 1+dis[u];
                q.add(v);
                vis[v] = true;
            }
        }
    }
}