class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int el : arr){
            int diff = el-difference;
            int res = map.getOrDefault(diff,0)+1;
            map.put(el,res);
            ans = Math.max(res,ans);
        }
        return ans;
    }
}