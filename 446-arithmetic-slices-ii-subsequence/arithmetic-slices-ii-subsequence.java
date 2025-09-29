class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        HashMap<Long,Integer>[] map = new HashMap[n];
        for(int i = 0; i<n; i++){
            map[i] = new HashMap<>();
        }
        int ans = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                long diff = (long)nums[i]-nums[j];
                int count = map[j].getOrDefault(diff,0);
                map[i].put(diff,map[i].getOrDefault(diff,0)+count+1);
                ans += count;
            }
        }
        return ans;
    }
}