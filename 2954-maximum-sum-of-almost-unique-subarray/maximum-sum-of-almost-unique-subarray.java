class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        long ans = 0;
        int n = nums.size();
        int st = 0;
        int end = 0;
        long sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (end < n) {
            int el = nums.get(end);
            map.put(el, map.getOrDefault(el, 0) + 1);
            sum += el;
            while (st <= end && end - st + 1 > k) {
                int t = nums.get(st);
                sum -= t;
                map.put(t, map.get(t) - 1);
                if (map.get(t) == 0) {
                    map.remove(t);
                }
                st++;
            }
            if (end - st + 1 == k && map.size() >= m) {
                ans = Math.max(ans, sum);
            }
            end++;
        }
        return ans;
    }
}