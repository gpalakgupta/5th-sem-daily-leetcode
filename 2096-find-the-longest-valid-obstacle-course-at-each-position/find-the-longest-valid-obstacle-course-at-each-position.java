class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        return helper(obstacles);
    }
    public int[] helper(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        int len = 0;
        int[] ans = new int[n];
        for(int i = 0; i<n; i++){
            int idx = search(0,len-1,arr[i],dp);
            if(idx == len){
                dp[len] = arr[i];
                len++;
            }
            else{
                dp[idx] = arr[i];
            }
            ans[i] = idx+1;
        }
        return ans;
    }
    public int search(int st, int end, int el, int[] dp){
        
        while(st <= end){
            int mid = st+(end-st)/2;
            if(dp[mid] <= el){
                st = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return st;
    }
}