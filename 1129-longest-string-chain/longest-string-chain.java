class Solution {
    public int longestStrChain(String[] words) {
        return helper(words);
    }
    public int helper(String[] words){
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int mx = 1;
       Arrays.sort(words, (a, b) -> a.length() - b.length());

        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                if(isvalid(words[i],words[j]) && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
            if(dp[i] > mx){
                mx = dp[i];
            }
        }
        return mx;
    }
    public boolean isvalid(String a, String b){
        if(a.length() != b.length()+1){
            return false;
        }
        int i = 0;
        int j = 0;
        while(i<a.length() && j<b.length()){
            if(a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return (j == b.length());
    }
}