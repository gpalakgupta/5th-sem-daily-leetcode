class Solution {
    public long countPairs(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int el : nums){
            int g = gcd(el,k);
            for(int key : map.keySet()){
                if(((long) key*g)%k == 0){
                    ans += map.get(key);
                }
            }
            map.put(g,map.getOrDefault(g,0)+1);
        }
        return ans;
    }
    public int gcd(int a, int b){
        return b == 0?a : gcd(b,a%b);
    }
}