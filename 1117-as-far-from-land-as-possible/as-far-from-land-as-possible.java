class Solution {
    int n;
    int m;

    public int maxDistance(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int ans = 0;
        boolean hasLand = false;
        boolean hasWater = false;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    hasLand = true;
                    q.add(new int[] { i, j });
                } else {
                    hasWater = true;
                }
            }
        }
        if ((!hasLand) || (!hasWater)) {
            return -1;
        }

        int level = -1;
        int[] r = { 0, -1, 0, 1 };
        int[] c = { -1, 0, 1, 0 };
        while (!q.isEmpty()) {
            int n1 = q.size();
            level++;
            for(int i = 0; i<n1; i++){
                int[] rv = q.poll();
                for(int i1 = 0; i1<4; i1++){
                    int cr = rv[0]+r[i1];
                    int cc = rv[1]+c[i1];
                    if(cr >= 0 && cc >= 0 && cr < n && cc < m && grid[cr][cc] == 0){
                        grid[cr][cc] = 1;
                        q.add(new int[]{cr,cc});
                    }
                }
            }
        }
        return level;
    }
}