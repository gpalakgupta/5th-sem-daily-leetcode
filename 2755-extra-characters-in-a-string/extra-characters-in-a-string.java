class Solution {
    int n;
    public int minExtraChar(String s, String[] dictionary) {
        n = s.length();
        HashSet<String> st = new HashSet<>();
        for(String str : dictionary){
            st.add(str);
        }
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(s,st,0,dp);
    }
    public int helper(String str, HashSet<String> st, int idx, int[] dp){
        if(idx >= n){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        int ans = Integer.MAX_VALUE;
        String s = "";
        for(int i = idx; i<n; i++){
            s+=str.charAt(i);
            int curr = st.contains(s) ? 0 : s.length();
            int next = helper(str,st,i+1,dp);
            ans = Math.min(ans,curr+next);
        }
        return dp[idx] = ans;
    }
}