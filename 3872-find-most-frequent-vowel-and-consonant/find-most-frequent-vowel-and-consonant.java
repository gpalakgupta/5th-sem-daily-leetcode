class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        String str = "aeiou";
        int a = 0;
        int b = 0;
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(str.contains(ch+"")){
                map1.put(ch,map1.getOrDefault(ch,0)+1);
                a = Math.max(a,map1.get(ch));
            }
            else{
                map2.put(ch,map2.getOrDefault(ch,0)+1);
                b = Math.max(b,map2.get(ch));

            }
        }
        return a+b;
    }
}