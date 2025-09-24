class Solution {
    public boolean isvalid(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
    public long countVowels(String word) {
        int n = word.length();
        long ans = 0;
        for(int i = 0; i<n; i++){
            char ch = word.charAt(i);
            if(isvalid(ch)){
                ans += (long)(i+1)*(n-i);
            }
        }
        return ans;
    }
}