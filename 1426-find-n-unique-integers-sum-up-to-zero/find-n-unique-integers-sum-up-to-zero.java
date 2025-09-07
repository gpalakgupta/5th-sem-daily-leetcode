class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int i = 0;
        int k = n/2;
        int el = -n/2;
        if(n % 2 != 0){
            while(i<n){
               ans[i++] = el++;
            }
        }
        else{
            while(i<n){
                if(i == k){
                    el++;
                }
                ans[i++] = el++;
            }
        }
        
        return ans;
    }
}