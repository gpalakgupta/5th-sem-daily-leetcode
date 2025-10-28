class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int el : nums){
            map.put(el,map.getOrDefault(el,0)+1);
        }
        // System.out.println(4^0);
        int ans = 0;
        for(int key : map.keySet()){
            if(map.get(key) > 1){
                ans^=key;
            }
        }
        return ans;
    }
}