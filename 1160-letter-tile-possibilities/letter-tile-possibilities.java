class Solution {
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        int[] freq = new int[26];
        for(int i = 0; i<n; i++){
            char ch = tiles.charAt(i);
            freq[ch-'A']++;
        }

        helper(freq);
        return count;
    }
    int count = -1;
    public void helper(int[] freq){
        count++;
        for(int i = 0; i<26; i++){
            if(freq[i] == 0){
                continue;
            }
            freq[i]--;
            helper(freq);
            freq[i]++;
        }
    }
}