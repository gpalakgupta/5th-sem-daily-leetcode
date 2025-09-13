class Solution {
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        // int[] freq = new int[26];
        // for(int i = 0; i<n; i++){
        //     char ch = tiles.charAt(i);
        //     freq[ch-'A']++;
        // }

        // helper(freq);
        // return count;
        boolean[] visited = new boolean[n];
        StringBuilder sb = new StringBuilder();
        HashSet<String> st = new HashSet<>();
        helper(tiles,sb,st,visited);
        return st.size()-1;
    }
    public void helper(String tiles,  StringBuilder sb, HashSet<String> st, boolean[] visited){
        st.add(sb.toString());
        for(int i = 0; i<tiles.length(); i++){
            if(visited[i] == true){
                continue;
            }
            visited[i] = true;
            sb.append(tiles.charAt(i));
            helper(tiles,sb,st,visited);
            visited[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
    // int count = -1;
    // public void helper(int[] freq){
    //     count++;
    //     for(int i = 0; i<26; i++){
    //         if(freq[i] == 0){
    //             continue;
    //         }
    //         freq[i]--;
    //         helper(freq);
    //         freq[i]++;
    //     }
    // }
}