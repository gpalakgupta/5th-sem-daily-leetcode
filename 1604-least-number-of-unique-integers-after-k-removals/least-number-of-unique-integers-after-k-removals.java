class Solution {
    public class Pair{
        int el;
        int val;
        public Pair(int el, int val){
            this.el = el;
            this.val = val;
        }
    }
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2){
                return o1.val - o2.val;
            }
        });

        for(int key : map.keySet()){
            pq.add(new Pair(key,map.get(key)));
        }
        while(!pq.isEmpty() && k != 0){
            Pair rv = pq.poll();
            if(k >= rv.val){
                k-=rv.val;
            }
            else{
                k = 0;
                pq.add(rv);
            }
        }
        return pq.size();
    }
}