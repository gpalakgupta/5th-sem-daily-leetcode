class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int cnt = 0;
        for (int el : nums) {
            pq.add((long)el);
        }
        while (pq.size() >= 2 && pq.peek() < k) {

            long a = pq.poll();
            long b = pq.poll();
            long ans = Math.min(a, b) * 2 + Math.max(a, b);
            pq.add(ans);
            cnt++;

        }
        if (pq.peek() < k) {
            return -1;
        }
        return cnt;
    }
}