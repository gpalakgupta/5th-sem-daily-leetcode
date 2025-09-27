class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0;
        int prev = 0;
        for(int[] a : stations){
            int loc = a[0];
            int cap = a[1];
            startFuel -= (loc-prev);
            while(!pq.isEmpty() && startFuel < 0){
                startFuel += pq.poll();
                ans++;
            }
            if(startFuel <0){
                return -1;
            }
            prev = loc;
            pq.add(cap);
        }

        startFuel -= (target-prev);
        while(!pq.isEmpty() && startFuel < 0){
            startFuel += pq.poll();
            ans++;
        }
        if(startFuel <0){
             return -1;
        }
        return ans;
    }
}