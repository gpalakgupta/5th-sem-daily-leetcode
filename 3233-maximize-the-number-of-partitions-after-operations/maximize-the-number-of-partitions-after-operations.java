class Solution {
    HashMap<String,Integer> map = new HashMap<>();
    public int maxPartitionsAfterOperations(String s, int k) {
        map.clear();
        return helper(s,k,0,-1,true);
    }
    public int helper(String s, int k, int idx, long uniChar, boolean canPart){
        if(idx >= s.length()){
            return 0;
        }


        String key = idx+"-"+uniChar+"-"+canPart;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int charIdx = s.charAt(idx)-'a';
        long canUpdate = uniChar | (1L << charIdx);
        long unicnt = Long.bitCount(canUpdate);
        int res = 0;
        if(unicnt > k){
            res = 1+ helper(s,k,idx+1, 1 << charIdx ,canPart);
        }
        else{
            res = helper(s,k,idx+1,canUpdate,canPart);
        }

        if(canPart){
            for(int i = 0; i<26; i++){
                long newcharidx = uniChar | (1L << i);
                long newcnt = Long.bitCount(newcharidx);
                if(newcnt > k){
                    res = Math.max(res,1+helper(s,k,idx+1, 1L<<i, false));
                }
                else{
                    res = Math.max(res,helper(s,k,idx+1,newcharidx,false));
                }
            }
        }
        map.put(key,res);
        return res;
    }
}