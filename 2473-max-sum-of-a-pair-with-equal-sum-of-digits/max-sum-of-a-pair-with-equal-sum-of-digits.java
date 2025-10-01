class Solution {
    public class Pair{
        int el;
        int s;
        public Pair(int el, int s){
            this.el = el;
            this.s = s;
        }
    }
    public int sum(int el){
        int ans = 0;
        while(el != 0){
            ans += el % 10;
            el/=10;
        }
        return ans;
    }
    public int maximumSum(int[] nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2){
                return o2.el-o1.el;
            }
        });
        
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int el : nums){
            int sod = sum(el);
            if(!map.containsKey(sod)){
                map.put(sod,new ArrayList<>());
            }
            map.get(sod).add(el);
        }

        int ans = -1;
        for(int key : map.keySet()){
            if(map.get(key).size() > 1){
                Collections.sort(map.get(key));
                Collections.reverse(map.get(key));
                ans = Math.max(ans,map.get(key).get(0)+map.get(key).get(1));
            }
        }
        return ans;
    }
}