class Solution {
    public int destroyTargets(int[] nums, int space) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int el : nums){
            map.put(el%space,map.getOrDefault(el%space,0)+1);
        }
        int mx = 0;
        for(int key : map.keySet()){
            mx = Math.max(mx,map.get(key));
        }

        int ans = Integer.MAX_VALUE;
         for(int el : nums){
            int rem = el % space;
            if(map.get(rem) == mx){
                ans = Math.min(ans,el);
            }
         }
        return ans;
    }
}