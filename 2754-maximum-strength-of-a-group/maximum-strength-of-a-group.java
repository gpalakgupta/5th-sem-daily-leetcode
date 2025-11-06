class Solution {
    public long maxStrength(int[] nums) {
        int n = nums.length;
        long ans = 1;
        int neg = 0;
        Arrays.sort(nums);
        int mx = -10;
        boolean f = false;
        for(int el : nums){
            if(el < 0){
                neg++;
            }
            else if(el > 0 ){
                ans*=el;
                f = true;
            }
            mx = Math.max(el,mx);
        }
        // for(int el : nums){
        //     System.out.print(el+" ");
        // }
        // System.out.println(neg);
        int i = 0;
        while(neg > 1){
            ans *= nums[i];
            ans*= nums[i+1];
            i+=2;
            neg-=2;
            f = true;
        }
        return (f) ? Math.max(ans,mx) : mx;
    }
}