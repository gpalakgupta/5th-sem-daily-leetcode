class Solution {
    public int halveArray(int[] nums) {
       
        double sum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int el : nums){
            pq.add(el/1.0);
            sum += el;
        }
        double hf = sum/2;
        int cnt = 0;
        while(sum > hf){
            double el = pq.poll();
            double half = el/2;
            sum-=half;
            pq.add(half);
            cnt++;
        }
        return cnt;
    }
}