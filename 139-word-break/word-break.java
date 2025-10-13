class Solution {
    int n;
    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        Boolean[] visited = new Boolean[n+1];
        return helper(s,wordDict,visited,0);
    }
    public boolean helper(String str, List<String> wordDict, Boolean[] visited, int idx){
        if(idx == n){
            return true;
        }
        if(visited[idx] != null){
            return visited[idx];
        }
        for(int i = idx+1; i<=n; i++){
            String s = str.substring(idx,i);
            if(wordDict.contains(s) && helper(str,wordDict,visited,i)){
               return visited[idx] = true;
            }
        }
        return visited[idx] = false;
    }
}