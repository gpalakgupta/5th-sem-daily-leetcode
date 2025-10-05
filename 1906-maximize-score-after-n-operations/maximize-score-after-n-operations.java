class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    public int gcd(int n1, int n2){
        return n2 == 0 ? n1 : gcd(n2, n1 % n2);
    }
    public int maxScore(int[] nums) {
        int n = nums.length;
        map.clear();
        boolean[] visited = new boolean[n];
        return helper(nums,1,visited);
    }
    public int helper(int[] nums, int op, boolean[] visited){
        int mxscore = 0;
        int n = nums.length;
        int mask = 0;
        for(int i = 0; i<n; i++){
            if(visited[i]){
                mask |= (1<<i);
            }
        }
        if(map.containsKey(mask)){
            return map.get(mask);
        }
        for(int i = 0; i<=n-2; i++){
            if(visited[i] == true){
                continue;
            }
            for(int j = i+1; j<n; j++){
                if(visited[j]){
                    continue;
                }
                visited[i] = true;
                visited[j] = true;
                int curr = op *gcd(nums[i],nums[j]);
                int remain = helper(nums,op+1,visited);
                mxscore = Math.max(mxscore,curr+remain);
                visited[i] = false;
                visited[j] = false;
            }
        }
        map.put(mask,mxscore);
        return mxscore;
    }
}