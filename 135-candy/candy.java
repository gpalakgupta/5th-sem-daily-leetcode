class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] pre = new int[n];
        int[] suff = new int[n];
        pre[0] = 1;
        suff[n-1] = 1;
        for(int i = 1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                pre[i] = pre[i-1]+1;
            }
            else{
                pre[i] = 1;
            }
        }
        for(int i = n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                suff[i] = suff[i+1]+1;
            }
            else{
                suff[i] = 1;
            }
        }
        int ans = 0;
        for(int i = 0; i<n; i++){
            ans += Math.max(pre[i],suff[i]);
        }
        return ans;
    }
}