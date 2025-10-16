class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int el : nums) {
            int rem = ((el % value) + value) % value;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        int mex = 0;
        while (map.containsKey(mex % value) && map.get(mex % value) > 0) {
            map.put(mex % value, map.get(mex % value) - 1);
            mex++;
        }
        return mex;
    }
}