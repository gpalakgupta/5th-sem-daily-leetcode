class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(s.charAt(i),i);
        }
        HashSet<Character> visited = new HashSet<>();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(visited.contains(ch)){
                continue;
            }
            while(!st.isEmpty() && ch < st.peek() && i <  map.getOrDefault(st.peek(),-1)){
                visited.remove(st.pop());
            }
            visited.add(ch);
            st.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}