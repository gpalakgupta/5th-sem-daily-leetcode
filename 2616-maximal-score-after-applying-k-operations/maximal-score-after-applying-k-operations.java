class Solution {
    public long maxKelements(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int el : nums){
            pq.add(el);
        }

        while(k != 0){
            int el = pq.poll();
            ans += el;
            el = (el%3 == 0) ? el/3 : el/3+1;
            pq.add(el);
            k--;
        }
        return ans;
    }
}