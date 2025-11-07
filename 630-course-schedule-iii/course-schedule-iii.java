class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)-> Integer.compare(a[1],b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int time = 0;
        for(int[] arr : courses){
            int a = arr[0];
            int b = arr[1];
            time += a;
            pq.add(a);
            if(time > b){
                time -= pq.poll();
            }
        }
        return pq.size();
    }
}