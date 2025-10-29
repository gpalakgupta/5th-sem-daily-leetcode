class Solution {
    int mod = 1000000007;
    HashMap<String,Long> map = new HashMap<>();
    public int numberOfWays(int startPos, int endPos, int k) {
      map.clear();
        return (int)(helper(startPos, endPos, k, 0)%mod);
    }

    public long helper(int st, int end, int k, int step) {

        if (step == k) {
            return (st == end) ? 1 : 0;
        }
        String key = st+"-"+step;;
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        long a = helper(st+1, end, k, step + 1);
        long b = helper(st-1, end, k, step + 1);
        long ans = (a + b)%mod;
        map.put(key,ans);
        return ans;
    }
}