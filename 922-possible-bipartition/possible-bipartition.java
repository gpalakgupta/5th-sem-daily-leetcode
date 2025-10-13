class Solution {
    public class Pair{
        int vtx;
        int des;
        public Pair(int vtx, int des){
            this.vtx = vtx;
            this.des = des;
        }
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 1; i<=n; i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] arr : dislikes){
            int a = arr[0];
            int b = arr[1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        return bfs(map);
    }
    public boolean bfs(HashMap<Integer,List<Integer>> map){
        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int src = 1; src<=map.size(); src++){
            if(mp.containsKey(src)){
                continue;
            }
            q.add(new Pair(src,0));
            while(!q.isEmpty()){
                Pair rv = q.poll();
                if(mp.containsKey(rv.vtx)){
                    if(mp.get(rv.vtx) != rv.des){
                        return false;
                    }
                    continue;
                }
                mp.put(rv.vtx,rv.des);
                for(int nbrs : map.get(rv.vtx)){
                    if(!mp.containsKey(nbrs)){
                        q.add(new Pair(nbrs,rv.des+1));
                    }
                }
            }
        }
        return true;
    }
}