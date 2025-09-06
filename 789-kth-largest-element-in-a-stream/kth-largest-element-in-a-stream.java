class KthLargest {
    PriorityQueue<Integer> pq;
    int t;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        t = k;
        for(int el : nums){
            pq.add(el);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size() > t){
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */