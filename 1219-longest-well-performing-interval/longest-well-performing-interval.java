class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            sum += (hours[i] > 8) ? 1 : -1;
            if (sum > 0) {
                ans = i + 1;
            } else {
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }
                if(map.containsKey(sum-1)){
                    ans = Math.max(ans,i-map.get(sum-1));
                }
            }

        }
        return ans;
    }
}