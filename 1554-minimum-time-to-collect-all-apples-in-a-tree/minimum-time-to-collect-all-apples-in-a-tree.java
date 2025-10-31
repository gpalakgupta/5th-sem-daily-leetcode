class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] arr : edges) {
            int a = arr[0];
            int b = arr[1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        HashSet<Integer> st = new HashSet<>();
        st.add(0);
        return dfs(map, hasApple, 0, st);

    }

    public int dfs(HashMap<Integer, List<Integer>> map, List<Boolean> hasApple, int src, HashSet<Integer> st) {
        
        int total = 0;
        for (int nbrs : map.get(src)) {
            if (st.contains(nbrs)) {
                continue;
            }
            st.add(nbrs);
            int time = dfs(map, hasApple, nbrs, st);
            if(time > 0 || hasApple.get(nbrs)){
                total += time+2;
            }
        }
        return total;
    }
}