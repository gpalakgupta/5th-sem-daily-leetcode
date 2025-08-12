class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        HashSet<Integer> st = new HashSet<>();
        for(int[] a : adjacentPairs){
            st.add(a[0]);
            st.add(a[1]);
        }
        for(int el : st){
            map.put(el,new ArrayList<>());
        }
        for(int [] ar : adjacentPairs){
            int a = ar[0];
            int b = ar[1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        return dfs(map);
    }
    public int[] dfs(HashMap<Integer,List<Integer>> map){
        int n = map.size();
        int[] ans = new int[n];
        int st = 0;
        for(int el : map.keySet()){
            if(map.get(el).size() == 1){
                st= el;
                break;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int i = 0;
        HashSet<Integer> visited = new HashSet<>();
         
        q.add(st);
        while(!q.isEmpty()){
            int rv = q.poll();
            if(visited.contains(rv)){
                continue;
            }
            visited.add(rv);
            ans[i++] = rv;
            for(int nbrs : map.get(rv)){
                if(!visited.contains(nbrs)){
                    q.add(nbrs);
                }
            }
        }
        
        return ans;
    }
}