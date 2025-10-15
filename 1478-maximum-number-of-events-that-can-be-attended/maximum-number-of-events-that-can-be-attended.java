class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->{
            if(a[0] == b[0]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        int n = events.length;
        int ans = 0;
        int el = 0;
        for(int[] arr : events){
            el = Math.max(el,arr[1]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        for(int day = 1; day<=el; day++){
            while(i < n && events[i][0] == day){
                pq.add(events[i][1]);
                i++;
            }
            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }
            
            if(!pq.isEmpty()){
                ans++;
                pq.poll();
            }
        }
        return ans;
    }
}