class Solution {
    public class Pair{
        int e1;
        int e2;
        public Pair(int e1, int e2){
            this.e1 = e1;
            this.e2 = e2;
        }
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2){
                return o1.e1-o2.e1;
            }
        });

        int ans = 0;
        for(int i = 0; i<difficulty.length; i++){
            pq.add(new Pair(difficulty[i],profit[i]));
        }
        int i = 0;
        int mx = 0;
        while(i <  worker.length && (!pq.isEmpty())){
            Pair o1 = pq.poll();
            if(o1.e1 <= worker[i]){
                mx = Math.max(o1.e2,mx);
            }
            else{
                ans += mx;
                i++;
                pq.add(o1);
            }
        }
        while(i<worker.length){
            ans += mx;
            i++;
        }
        return ans;
    }
}