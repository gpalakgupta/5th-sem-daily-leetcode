class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int cnt = 0;
        int prev = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            int minVal = nums[i]-k;
            if(prev < minVal){
                prev = minVal;
                cnt++;
            }
            else if(prev < nums[i]+k){
                prev = prev+1;
                cnt++;
            }
        }
        return cnt;
    }
}