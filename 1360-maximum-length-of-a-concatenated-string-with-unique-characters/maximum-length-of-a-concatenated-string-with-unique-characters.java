class Solution {
    HashMap<String,Integer> map = new HashMap<>();
    public int maxLength(List<String> arr) {
        String temp = "";
        int n = arr.size();
        map.clear();
        return solve(arr,0,temp,n);
    }
    public int solve(List<String> arr, int i, String temp, int n){
        if(i >= n){
            return temp.length();
        }
        String key = temp+"i";
        if(map.containsKey(key)){
            return map.get(key);
        }
        int  take = 0;
        int notake = 0;
        if(contains(arr.get(i),temp)){
            notake = solve(arr,i+1,temp,n);
        }
        else{
            take = solve(arr,i+1,temp+arr.get(i),n);
            notake = solve(arr,i+1,temp,n);
        }
        int ans = Math.max(take,notake);
        map.put(key,ans);
        return ans;
    }
    public boolean contains(String s1, String s2){
        int[] freq = new int[26];
        for(char ch : s1.toCharArray()){
            if(freq[ch-'a'] > 0){
                return true;
            }
            freq[ch-'a']++;
        }
        for(char ch : s2.toCharArray()){
            if(freq[ch-'a'] > 0){
                return true;
            }
        }
        return false;
    }
}