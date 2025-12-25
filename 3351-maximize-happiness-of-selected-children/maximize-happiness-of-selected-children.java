class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int j = 0;
        int n = happiness.length;
        long ans = 0;
        for(int i = n-1; i>=0 && k > 0; i--){
            ans += (happiness[i]-j > 0) ? happiness[i]-j : 0;
            k--;
            j++;
        }
        return ans;
    }
}