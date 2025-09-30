class Solution {
    public List<Integer> findAnagrams(String s2, String s1) {
        int n1 = s1.length();
        int n2 = s2.length();
        List<Integer> ll = new ArrayList<>();
        if(n1 > n2){
            return ll;
        }
         HashMap<Character,Integer> mp = new HashMap<>();
        for(char ch : s1.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer> mp1 = new HashMap<>();
        int st = 0;
        int end = 0;
        while(end < n2){
            char ch = s2.charAt(end);
            mp1.put(ch,mp1.getOrDefault(ch,0)+1);
            while(end - st + 1 > n1){
                char t = s2.charAt(st);
                mp1.put(t,mp1.get(t)-1);
                if(mp1.get(t) == 0){
                    mp1.remove(t);
                }
                st++;
            }
              if(mp1.equals(mp)){
                    ll.add(st);
                }
            end++;
        }
        return ll;
    }
}