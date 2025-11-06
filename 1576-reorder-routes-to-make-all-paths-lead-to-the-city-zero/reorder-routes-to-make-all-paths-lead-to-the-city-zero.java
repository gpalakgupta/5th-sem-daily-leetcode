class Solution {
    int res;
    public class Pair{
        int first;
        int sec;
        public Pair(int first, int sec){
            this.first = first;
            this.sec = sec;
        }
    }

    public void dfs(HashMap<Integer,List<Pair>> map, int node, int parent){
        for(Pair nbrs : map.get(node)){
            int u = nbrs.first;
            int v = nbrs.sec;
            if(u != parent){
                if(v == 1){
                    res++;
                }
                dfs(map,u,node);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        HashMap<Integer,List<Pair>> map = new HashMap<>();
        res = 0;
        for(int i = 0; i<n; i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] arr : connections){
            int a = arr[0];
            int b = arr[1];
            map.get(a).add(new Pair(b,1));
            map.get(b).add(new Pair(a,0));
        }
        dfs(map,0,-1);
        return res;
    }
}