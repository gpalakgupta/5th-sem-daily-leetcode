class Solution {
    

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        HashMap<Character, List<Character>> map = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            map.put(ch, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            map.get(a).add(b);
            map.get(b).add(a);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            HashSet<Character> st = new HashSet<>();
            char ch = dfs(baseStr.charAt(i), map, st);
            sb.append(ch);
        }
        return sb.toString();
    }

    public char dfs(char ch, HashMap<Character, List<Character>> map, HashSet<Character> visited) {
        visited.add(ch);
        char ans = ch;
        for (char nbrs : map.get(ch)) {
            if(visited.contains(nbrs)){
                continue;
            }
            
            char min  =  dfs(nbrs,map,visited);
            if(min < ans){
                ans = min;
            }
        }
        return ans;
    }
}