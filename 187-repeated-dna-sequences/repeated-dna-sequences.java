class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        HashMap<String,Integer> st = new HashMap<>();
        int n = s.length();
        int k = 10;
        if(n < 10){
            return ans;
        }
        for(int i = k; i<=n; i++){
            String str = s.substring(i-k,i);
            st.put(str,st.getOrDefault(str,0)+1);
        }
        for(String key : st.keySet()){
            if(st.get(key) > 1){
                ans.add(key);
            }
        }
        return ans;
    }
}