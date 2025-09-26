class Solution {
    HashMap<String,Integer> map = new HashMap<>();
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        return helper(0,0,n,m,dungeon);
    }
    public int helper(int i, int j, int n, int m, int[][] dungeon){
        if(i >= n || j >= m){
            return (int)(1e9);
        }

        if(i == n-1 && j == m-1){
            if(dungeon[i][j] > 0){
                return 1;
            }
            return Math.abs(dungeon[i][j])+1;
        }
        String key = i+"-"+j;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int down = helper(i+1,j,n,m,dungeon);
        int right = helper(i,j+1,n,m,dungeon);

        int result = Math.min(down,right)-dungeon[i][j];
        int want = result > 0 ? result : 1;
        map.put(key,want);
        return want;
    }
}