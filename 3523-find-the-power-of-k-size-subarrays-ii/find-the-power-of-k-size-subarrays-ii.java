class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int res[]=new int[n-k+1];
        int cons=1;
        if(k==1){
             return nums;
        }
        for (int i=1;i<n;i++){
            if(nums[i]==nums[i-1]+1){
                cons++;
            }
            else{
                cons=1;
            }
            if(i>=k-1){
                if(cons>=k){
                    res[i-k+1]=nums[i];
                }
                else{
                    res[i-k+1]=-1;
                }
            }}
        return res;
    }
}