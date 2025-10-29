class Solution {
    int mod = 1000000007;
    HashMap<String,Long> map = new HashMap<>();
    public int numWays(int steps, int arrLen) {
        map.clear();
        return (int) (helper(0, 0, arrLen, steps) % mod);
    }

    public long helper(int idx, int step, int n, int steps){
        if(step == steps){
            if(idx == 0){
                return 1;
            }
            return 0;
        }
        if(idx >= n || idx < 0){
            return 0;
        }
       String key = idx+"-"+step;
       if(map.containsKey(key)){
        return map.get(key);
       }
        long a = helper(idx+1,step+1,n, steps);
        long b = helper(idx-1,step+1,n,steps);
        long c = helper(idx,step+1,n,steps);
        long ans = (a+b+c)%mod;
        map.put(key,ans);
        return ans;
    }
}