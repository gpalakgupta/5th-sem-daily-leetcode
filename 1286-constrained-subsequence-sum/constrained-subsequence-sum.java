class Solution {
    public class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        int result = arr[0];
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2){
                return o2.first - o1.first;
            }
        });
        pq.add(new Pair(arr[0], 0));
        for (int i = 1; i < n; i++) {
            while (!pq.isEmpty() && i - pq.peek().second > k) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                arr[i] = Math.max(arr[i], pq.peek().first + arr[i]);
            }
            pq.add(new Pair(arr[i], i));
            result = Math.max(result, pq.peek().first);
        }
        return result;
    }
}