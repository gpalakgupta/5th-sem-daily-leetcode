class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int[] ans = new int[n];
        Arrays.sort(potions);
        for(int i = 0; i<n; i++){
            int lo = 0;
            int hi = potions.length-1;
            int res = 0;
            while(lo <= hi){
                int mid = lo+(hi-lo)/2;
                long prod = (long)potions[mid]*spells[i];
                if(prod >= success){
                    res = potions.length-mid;
                    hi = mid-1;
                }
                else{
                    lo = mid+1;
                }
            }
            ans[i] = res;
        }
        return ans;
    }
}