class Solution {
    public long countStableSubarrays(int[] capacity) {
        int n = capacity.length;
        long ans = 0;
        HashMap<Integer, HashMap<Long, Integer>> map = new HashMap<>();
        long p = 0;
        for (int i = 0; i < n; i++) {
            int el = capacity[i];
            long diff = p - el;
            if (map.containsKey(el) && map.get(el).containsKey(diff)) {
                ans += map.get(el).get(diff);
            }
            p += el;
            map.putIfAbsent(el, new HashMap<>());
            map.get(el).put(p, map.get(el).getOrDefault(p, 0) + 1);
            if (i > 0 && capacity[i] == 0 && capacity[i - 1] == 0)
                ans--;

        }
        return ans;
    }
}