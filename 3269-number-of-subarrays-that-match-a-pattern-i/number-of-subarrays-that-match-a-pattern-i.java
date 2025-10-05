class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;
        int cnt = 0;
        for(int i = 0; i<=n-m-1; i++){
            int k = 0;
            boolean f = false;
            for(int j = i+1; j<i+m+1; j++){
                if(pattern[k] == 1 && nums[j] <= nums[j-1]){
                    f = false;
                    break;
                }
                if(pattern[k] == 0 && nums[j] != nums[j-1]){
                    f = false;
                    break;
                }
                if(pattern[k] == -1 && nums[j] >= nums[j-1]){
                    f = false;
                    break;
                }
                f = true;
                k++;
            }
            if(f){
                cnt++;
            }
        }
        return cnt;
    }
}