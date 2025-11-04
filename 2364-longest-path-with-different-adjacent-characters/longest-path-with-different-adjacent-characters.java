class Solution {
    int res;
   
    public int longestPath(int[] parent, String s) {
        res = 0;
        int n = parent.length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(i,new ArrayList<>());
        }
        for(int i = 1; i<n; i++){
            int a = i;
            int b = parent[i];
            map.get(a).add(b);
            map.get(b).add(a);
        }

        dfs(map,0,-1,s);
        return res;
    }
    public int dfs(HashMap<Integer,List<Integer>> map, int curr, int parent, String str){
        int longest = 0;
        int sec_long = 0;
        for(int nbrs : map.get(curr)){
            if(nbrs == parent){
                continue;
            }
            int child = dfs(map,nbrs,curr,str);
            if(str.charAt(nbrs) == str.charAt(curr)){
                continue;
            }
            if(child > longest){
                sec_long = longest;
                longest = child;
            }
            else if(child > sec_long){
                sec_long = child;
            }
        }
        res = Math.max(res,longest+sec_long+1);
        return longest+1;
    }
}