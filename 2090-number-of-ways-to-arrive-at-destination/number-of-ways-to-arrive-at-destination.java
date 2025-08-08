class Solution {
    public class Pair{
        long first;
        int second;
        public Pair(long first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int countPaths(int n, int[][] roads) {
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(i,new HashMap<>());
        }
        for(int i = 0; i<roads.length; i++){
            int a = roads[i][0];
            int b = roads[i][1];
            int cost = roads[i][2];
            map.get(a).put(b,cost);
            map.get(b).put(a,cost);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            
            public int compare(Pair o1, Pair o2){
                return Long.compare(o1.first,o2.first);
            }
        });
        int mod = 1000000007;
        int[] ways = new int[n];
        long[] dis = new long[n];
        Arrays.fill(ways,0);
        Arrays.fill(dis,Long.MAX_VALUE);
        ways[0] = 1;
        dis[0] = 0;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair rv = pq.poll();
            long des = rv.first;
            int node = rv.second;
            if(des > dis[node]){
                continue;
            }
            for(int nbrs : map.get(node).keySet()){
                long cost = map.get(node).get(nbrs);
                if(cost+des < dis[nbrs]){
                    dis[nbrs] = cost+des;
                    pq.add(new Pair(cost+des,nbrs));
                    ways[nbrs] = ways[node];
                }
                else if(cost+des == dis[nbrs]){
                    ways[nbrs] = (ways[nbrs]+ways[node])%mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}