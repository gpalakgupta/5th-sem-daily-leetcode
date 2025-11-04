class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        int m = baseStr.length();
        HashMap<Character,List<Character>> map = new HashMap<>();
        for(char ch = 'a'; ch <='z'; ch++){
            map.put(ch,new ArrayList<>());
        }
        for(int i = 0; i<n; i++){
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            map.get(a).add(b);
            map.get(b).add(a);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<m; i++){
            HashSet<Character> st = new HashSet<>();
            char min = dfs(map,st,baseStr.charAt(i));
            sb.append(min);
        }
        return sb.toString();
    }
    public char dfs(HashMap<Character,List<Character>> map, HashSet<Character> st, char ch){
        char min = ch;
        st.add(min);
        for(char nbrs : map.get(ch)){
            if(st.contains(nbrs)){
                continue;
            }
            char t = dfs(map,st,nbrs);
            if(t < min){
                min = t;
            }
        }
        return min;
    }
}