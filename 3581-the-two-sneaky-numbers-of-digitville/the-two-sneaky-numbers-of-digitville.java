class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int el : nums) {
            map.put(el, map.getOrDefault(el, 0) + 1);
        }
        int i = 0;
        for (int el : map.keySet()) {
            if(map.get(el) == 2){
                ans[i++] = el;
            }
        }
        return ans;
    }
}