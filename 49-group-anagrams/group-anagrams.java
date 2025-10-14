class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String el : strs){
            String key =  get(el);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(el);
        }
        for(String key : map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }
    public String get(String str){
        int[] freq = new int[26];
        for(char ch : str.toCharArray()){
            freq[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int el : freq){
            sb.append(el+"-");
        }
        return sb.toString();
    }
}