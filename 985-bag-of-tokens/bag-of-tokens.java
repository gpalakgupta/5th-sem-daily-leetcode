class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        Arrays.sort(tokens);
        int count = 0;
        int i = 0;
        int j = n-1;
        int ans = 0;
        while(i<=j){
            if(power >= tokens[i]){
                power-=tokens[i];
                count++;
                i++;
            }
            else if(count>0){
                power+=tokens[j];
                count--;
                j--;
            }
            else{
                return ans;
            }
            // System.out.println(count);
            ans = Math.max(ans,count);
        }
        return ans;
    }
}