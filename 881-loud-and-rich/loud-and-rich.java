class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] arr : richer){
            int a = arr[0];
            int b = arr[1];
            map.get(b).add(a);
        }
        int[] res = new int[n];
        Arrays.fill(res,-1);
        for(int i = 0; i<n; i++){
            res[i] = dfs(map,quiet,i,res);
        }
        return res;
    }
    public int dfs(HashMap<Integer,List<Integer>> map, int[] quiet, int node, int[] res){
        if(res[node] != -1){
            return res[node];
        }
        int min = quiet[node];
        int minpos = node;
        for(int nbrs : map.get(node)){
            int idx = dfs(map,quiet,nbrs,res);
            if(quiet[idx] < min){
                min = quiet[idx];
                minpos = idx;
            }
        }
        return res[node] = minpos;
    }
}