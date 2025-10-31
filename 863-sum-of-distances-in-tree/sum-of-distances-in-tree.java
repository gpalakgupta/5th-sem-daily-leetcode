class Solution {
    int[] count;
    int base_node;
    int N;

    public int dfs(HashMap<Integer, List<Integer>> map, int curr, int pre, int depth) {
        int total = 1;
        base_node += depth;
        for (int nbrs : map.get(curr)) {
            if (nbrs == pre) {
                continue;
            }
            total += dfs(map, nbrs, curr, depth + 1);
        }
        count[curr] = total;
        return total;
    }

    public void DFS(HashMap<Integer, List<Integer>> map, int curr, int pre, int[] res) {
        for (int nbrs : map.get(curr)) {
            if (nbrs == pre) {
                continue;
            }
            res[nbrs] = res[curr] - count[nbrs] + (N - count[nbrs]);
            DFS(map, nbrs, curr, res);
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N = n;
        count = new int[n];
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

        base_node = 0;
        dfs(map, 0, -1, 0);
        int[] res = new int[n];
        res[0] = base_node;
        DFS(map, 0, -1, res);
        return res;

    }
}