class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for(int el : nums){
            min = Math.min(min,el);
            max = Math.max(max,el);
        }
        long diff = Math.abs(max-min);
        return diff*k;
    }
}