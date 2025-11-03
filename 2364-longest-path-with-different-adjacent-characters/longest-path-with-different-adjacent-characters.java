class Solution {
    int res;

    public int dfs(HashMap<Integer, List<Integer>> map, int curr, int parent, String s) {
        int longest = 0;
        int sec_long = 0;
        for (int nbrs : map.get(curr)) {
            if (nbrs == parent) {
                continue;
            }
            int childLen = dfs(map, nbrs, curr, s);
            if (s.charAt(nbrs) == s.charAt(curr)) {
                continue;
            }
          
            if (childLen > longest) {
                sec_long = longest;
                longest = childLen;
            } else if (childLen > sec_long) {
                sec_long = childLen;
            }

        }
      
        res = Math.max(res, longest + sec_long + 1);
        return longest + 1;
    }

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        res = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int a = i;
            int b = parent[i];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        dfs(map, 0, -1, s);
        return res;
    }
}