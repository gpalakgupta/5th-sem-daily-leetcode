class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        Arrays.sort(piles);
        int ans = 0;
        int k = n/3;
        for(int i = k; i<n; i+=2){
            ans += piles[i];
        }
        return ans;
    }
}