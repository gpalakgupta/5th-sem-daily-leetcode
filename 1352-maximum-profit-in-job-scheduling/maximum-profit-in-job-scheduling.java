class Solution {
    public class tuple{
        int first;
        int second;
        int cost;
        public tuple(int first, int second, int cost){
            this.first = first;
            this.second = second;
            this.cost = cost;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        tuple[] arr = new tuple[n];
        for(int i = 0; i<n; i++){
            arr[i] = new tuple(startTime[i],endTime[i],profit[i]);
        }
        Arrays.sort(arr,new Comparator<tuple>(){
            @Override
            public int compare(tuple o1, tuple o2){
                return o1.first - o2.first;
            }
        });
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(arr,0,n,dp);
    }
    
    public int helper(tuple[] arr, int idx, int n, int[] dp){
        if(idx >= n){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }
        int end = arr[idx].second;
        int next = nextTake(arr,idx+1,end);
        int take = arr[idx].cost+helper(arr,next,n,dp);
        int notake = helper(arr,idx+1,n,dp);

        
        return dp[idx] = Math.max(take,notake);
    }
    public int nextTake(tuple[] arr, int idx, int end){
        for(int i = idx; i<arr.length; i++){
            if(arr[i].first >= end){
                return i;
            }
        }
        return arr.length;
    }
}