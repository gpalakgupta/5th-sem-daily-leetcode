class Solution{
    int n;
    public int minExtraChar(String s, String[] dictionary) {
        n = s.length();
        HashSet<String> st = new HashSet<>();
        for(String str : dictionary){
            st.add(str);
        }

        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(0,s,st,dp);
    }
    public int helper(int idx, String s, HashSet<String> st, int[] dp){
        if(idx >= n){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }

        String str = "";
        int min = Integer.MAX_VALUE;
        for(int i = idx; i<n; i++){
            str+=s.charAt(i);
            int curr = (st.contains(str)) ? 0 : str.length();
            int next = helper(i+1,s,st,dp);
            int total = curr+next;
            min = Math.min(total,min);
        }
        return dp[idx] = min;
    }
}