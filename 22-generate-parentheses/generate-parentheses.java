class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n,ans,0,0,"");
        return ans;
    }
    public void helper(int n, List<String> ans, int open, int close,String str){
        if(open == n && close == n){
            ans.add(str);
            return;
        }
        if(open > n || close > n || close > open){
            return;
        }
        helper(n,ans,open+1,close,str+'(');
        helper(n,ans,open,close+1,str+')');
    }
}