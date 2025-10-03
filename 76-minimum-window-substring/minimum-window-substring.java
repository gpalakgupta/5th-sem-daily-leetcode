class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int st = 0;
        int end = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int c = 0;
        int start = -1;
        int minlen = Integer.MAX_VALUE;
        while(end < n){
            char ch = s.charAt(end);
            map.put(ch,map.getOrDefault(ch,0)-1);
            if(map.get(ch) >= 0){
                c++;
            }
            while(c == t.length()){
                char ch1 = s.charAt(st);
                if(end-st+1 < minlen){
                    minlen = end-st+1;
                    start = st;
                }
                map.put(ch1,map.get(ch1)+1);
                if(map.get(ch1) > 0){
                    c--;
                }
                st++;
            }
            end++;
        }
        return start == -1 ? "" : s.substring(start,start+minlen);
    }
}