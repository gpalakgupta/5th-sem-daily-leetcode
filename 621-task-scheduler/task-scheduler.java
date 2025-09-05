class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch : tasks){
            freq[ch-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int el : freq){
            if(el > 0){
                pq.add(el);
            }
        }

        int time = 0;
        while(!pq.isEmpty()){
            List<Integer> ll = new ArrayList<>();
            for(int i = 1; i<=n+1; i++){
                if(!pq.isEmpty()){
                    int el = pq.poll();
                    el--;
                    ll.add(el);
                }
            }

            for(int el : ll){
                if(el > 0){
                    pq.add(el);
                }
            }

            if(pq.isEmpty()){
                time+=ll.size();
            }
            else{
                time+=n+1;
            }
        }
        return time;
    }
}