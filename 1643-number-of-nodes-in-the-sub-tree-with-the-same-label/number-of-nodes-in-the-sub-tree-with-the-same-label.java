class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i= 0; i<n; i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] arr : edges){
            int a = arr[0];
            int b = arr[1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        int[] res = new int[n];
        int[] count = new int[26];
        dfs(map,labels,res,0,-1,count);
        return res;
    }

    public void dfs(HashMap<Integer,List<Integer>> map, String str, int[] res, int curr, int parent, int[] count){
        char ch = str.charAt(curr);
        int before_cnt = count[ch-'a'];
        count[ch-'a']+=1;
        for(int nbrs : map.get(curr)){
            if(nbrs == parent){
                continue;
            }
            dfs(map,str,res,nbrs,curr,count);
        }
        int after = count[ch-'a'];
        res[curr] = after-before_cnt;
    }
}