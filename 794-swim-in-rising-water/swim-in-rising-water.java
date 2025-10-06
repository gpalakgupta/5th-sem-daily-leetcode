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
                return o1.val - o2.val;
            }
        });

        int ans = -1;
        pq.add(new Pair(grid[0][0],0,0));
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[] r = {0,-1,0,1};
        int[] c = {-1,0,1,0};
        while(!pq.isEmpty()){
            Pair rv = pq.poll();
            int val = rv.val;
            int row = rv.i;
            int col = rv.j;
            ans = Math.max(ans,val);
            if(row == n-1 && col == n-1){
                return ans;
            }
            visited[row][col] = true;
            for(int i = 0; i<4; i++){
                int cr = row+r[i];
                int cc = col+c[i];
                if(cr >= 0 && cc >= 0 && cr < n && cc < n && (visited[cr][cc] == false)){
                    pq.add(new Pair(grid[cr][cc],cr,cc));
                }
            }
        }
        return -1;
    }
}