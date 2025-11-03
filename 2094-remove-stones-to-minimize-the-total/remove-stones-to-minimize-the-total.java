class Solution {
    public int minStoneSum(int[] piles, int k) {
        int sum = 0;
        int n = piles.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int el : piles) {
            sum += el;
            pq.add(el);
        }
        // System.out.println(sum);
        while (!pq.isEmpty() && k > 0) {
            int el = pq.poll();
            sum -= el;
            // System.out.print(sum + " ");

            el = (el % 2 == 0) ? el / 2 : el / 2 + 1;
            sum += el;
            // System.out.println(sum);
            pq.add(el);
            k--;

        }
        
        return sum;
    }
}