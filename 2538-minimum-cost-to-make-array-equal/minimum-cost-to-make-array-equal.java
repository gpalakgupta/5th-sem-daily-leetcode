class Solution {
    public long minCost(int[] nums, int[] cost) {
        long ans = Integer.MAX_VALUE;
        int n = nums.length;
        int st = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int el : nums){
            st = Math.min(st,el);
            end = Math.max(end,el);
        }
        while(st <= end){
            int mid = st+(end-st)/2;
            long cost1 = helper(nums,cost,mid);
            long cost2 = helper(nums,cost,mid+1);
            ans = Math.min(cost1,cost2);
            if(cost2 > cost1){
                end = mid-1;
            }
            else{
                st = mid+1;
            }
        }
        return ans;
    }
    public long helper(int[] nums, int[] cost, int target){
        long ans = 0;
        for(int i = 0; i<nums.length; i++){
            ans += (long)Math.abs(nums[i]-target)*cost[i];
        }
        return ans;
    }
}