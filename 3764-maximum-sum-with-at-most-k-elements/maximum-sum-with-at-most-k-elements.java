class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        long ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<n; i++){
            Arrays.sort(grid[i]);
            for(int j = m-1; j>= m-limits[i]; j--){
                pq.add(grid[i][j]);
            }
        }
        while(!pq.isEmpty() && k != 0){
            ans+= pq.poll();
            k--;
        }
        return ans;
    }
}