class Solution {
    public class Pair{
        int node;
        int cost;
        public Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    public int minScore(int n, int[][] roads) {
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i = 1; i<=n; i++){
            map.put(i,new HashMap<>());
        }
        for(int i = 0; i<roads.length; i++){
            int a = roads[i][0];
            int b = roads[i][1];
            int cost = roads[i][2];
            map.get(a).put(b,cost);
            map.get(b).put(a,cost);
        }
        return bfs(map,n);
    }
    public int bfs(HashMap<Integer,HashMap<Integer,Integer>> map, int n){
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2){
                return o1.cost - o2.cost;
            }
        });
        pq.add(new Pair(1,Integer.MAX_VALUE));
        int ans = Integer.MAX_VALUE;
        HashSet<Integer> visited = new HashSet<>();
        while(!pq.isEmpty()){
            Pair rv = pq.poll();
            int node = rv.node;
            int cost = rv.cost;
            if(visited.contains(node)){
                continue;
            }
            visited.add(node);
            ans = Math.min(ans,cost);
            
            for(int nbrs : map.get(node).keySet()){
                if(!visited.contains(nbrs)){
                    pq.add(new Pair(nbrs,map.get(node).get(nbrs)));
                }

            }
        }
        return ans;
    }
}