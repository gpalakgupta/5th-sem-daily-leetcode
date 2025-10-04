class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int ans = 0;
        for(int i = 0; i<n; i++){
            if(grumpy[i] == 0){
                ans += customers[i];
            }
        }
        // System.out.println(ans);
        int mx = 0;
        int st = 0;
        int end = 0;
        int sum = 0;
        while(end < n){
            if(grumpy[end] == 1){
                sum+= customers[end];
            }
            while(end-st+1 > minutes){
                if(grumpy[st] == 1){
                    sum-=customers[st];
                }
                st++;
            }
            mx = Math.max(mx,sum);
            end++;
        }
        // System.out.println(mx);
        return ans+mx;
    }
}