class Solution {
    public class Bipart{
        int vtx;
        int des;
        public Bipart(int vtx, int des){
            this.vtx = vtx;
            this.des = des;
        }
    }
    public boolean isBipartite(int[][] graph) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<Bipart> q = new LinkedList<>();
        for(int i = 0; i<graph.length; i++){
            if(map.containsKey(i)){
                continue;
            }
            q.add(new Bipart(i,0));
            while(!q.isEmpty()){
                Bipart rv = q.poll();
                if(map.containsKey(rv.vtx)){
                    if(map.get(rv.vtx) != rv.des){
                        return false;
                    }
                    continue;
                }
                map.put(rv.vtx,rv.des);
                for(int nbrs : graph[rv.vtx]){
                    if(!map.containsKey(nbrs)){
                        q.add(new Bipart(nbrs,rv.des+1));
                    }
                }
            }
        }
        return true;
    }
}