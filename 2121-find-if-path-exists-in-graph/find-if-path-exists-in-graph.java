class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(i,new ArrayList<>());
        }
        for(int i = 0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            map.get(a).add(b);
            map.get(b).add(a);
        }

        return bfs(map,source, destination);
    }
    public boolean bfs(HashMap<Integer,List<Integer>> map, int src, int des){
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int rv = q.poll();
            if(visited.contains(rv)){
                continue;
            }
            if(rv == des){
                return true;
            }
            visited.add(rv);
            for(int nbrs : map.get(rv)){
                if(!visited.contains(nbrs)){
                    q.add(nbrs);
                }
            }
        }
        return false;
    }
}