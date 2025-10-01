class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int sum1 = 0;
        int ans1 = 0;
        int i = 0;
        while(i<n){
            sum1 += nums[i];
            ans1 = Math.max(ans1,sum1);
            if(sum1 <= 0){
                sum1 = 0;
            }
            i++;
        }
        // System.out.println(ans1);
        i = 0;
        int ans2 = Integer.MAX_VALUE;
        int sum2 = 0;
        while(i<n){
            sum2 += nums[i];
            ans2 = Math.min(ans2,sum2);
            if(sum2 >= 0){
                sum2 = 0;
            }
            i++;
        }
        return Math.max(Math.abs(ans1),Math.abs(ans2));
    }
}