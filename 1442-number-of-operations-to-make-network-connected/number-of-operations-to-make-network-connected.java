class Solution {
    public int makeConnected(int n, int[][] connections) {
        int v = connections.length;
        if(n-1 > v){
            return -1;
        }
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(i,new ArrayList<>());
        }
        for(int i = 0; i<v; i++){
            int a = connections[i][0];
            int b = connections[i][1];
            map.get(a).add(b);
            map.get(b).add(a); 
        }
        return dfs(map,n)-1;
    }
    public int dfs(HashMap<Integer,List<Integer>> map,int n){
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;
        for(int src = 0; src<n; src++){
            if(visited.contains(src)){
                continue;
            }
            ans++;
            q.add(src);
            while(!q.isEmpty()){
                int node = q.poll();
                if(visited.contains(node)){
                     
                    continue;
                }
                visited.add(node);
                for(int nbrs : map.get(node)){
                    if(!visited.contains(nbrs)){
                        q.add(nbrs);
                    }
                }
            }
        }
        return ans;
    }
}