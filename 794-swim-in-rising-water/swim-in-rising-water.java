class Solution {
    public class Pair{
        int val;
        int i;
        int j;
        public Pair(int val, int i, int j){
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2){
                return o1.val-o2.val;
            }
        });
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        pq.add(new Pair(grid[0][0],0,0));
        int[] row = {0,-1,0,1};
        int[] col = {-1,0,1,0};
        int ans = 0;
        while(!pq.isEmpty()){
            Pair rv = pq.poll();
            int r = rv.i;
            int c = rv.j;
            int val = rv.val;
            ans = Math.max(ans,val);
            if(r == n-1 && c == n-1){
                return ans;
            }
            for(int i = 0; i<4; i++){
                int cr = r+row[i];
                int cc = c+col[i];
                if(cr >= 0 && cr < n && cc >= 0 && cc < n && !visited[cr][cc]){
                    pq.add(new Pair(grid[cr][cc],cr,cc));
                    visited[cr][cc] = true;
                }
            }
        }
        return -1;
    }
}