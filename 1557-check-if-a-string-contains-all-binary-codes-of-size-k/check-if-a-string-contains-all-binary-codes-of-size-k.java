class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> st = new HashSet<>();
        for(int i = k; i<=s.length(); i++){
            st.add(s.substring(i-k,i));
        }
        return (st.size() == Math.pow(2,k))  ? true : false;
    }
}