class Solution {
    int mod = 1000000007;
    HashMap<Integer,Integer> map = new HashMap<>();
    public int countGoodStrings(int low, int high, int zero, int one) {
        map.clear();
        return helper(low,high,zero,one,0,0);
    }
    public int helper(int l, int h, int z, int o, int num, int isvalid){
        if(num > h){
            return 0;
        }
        if(map.containsKey(num)){
            return map.get(num);
            
        }
        if(num >= l && num <= h){
            isvalid = 1;
        }

        int one = helper(l,h,z,o,num+o,isvalid);
        int zero = helper(l,h,z,o,num+z,isvalid);
        int ans =  (isvalid+one+zero)%mod;
        map.put(num,ans);
        return ans;
    }
}