class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int st = 0;
        int end = 0;
        int ans = 0;
        HashSet<Character> st1 = new HashSet<>();
        while(end < n){
            char ch = s.charAt(end);
            while(st <= end && st1.contains(ch)){
                st1.remove(s.charAt(st));
                st++;
            }
            st1.add(ch);
            ans = Math.max(ans,end-st+1);
            end++;
        }
        return ans;
    }
}