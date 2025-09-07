class Solution {
    public int minOperations(String s) {
        int count = 0;
        int n = s.length();
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            int cost = ('a'- ch+26)%26;
            count = Math.max(count,cost);
        }
        return count;
    }
}