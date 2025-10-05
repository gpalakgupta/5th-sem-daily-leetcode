class Solution {
    HashMap<String,Integer> map = new HashMap<>();
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        map.clear();
        return helper(piles,0,k);
    }
    public int helper(List<List<Integer>> piles, int idx, int k){
        if(idx >= piles.size()){
            return 0;
        }
        if(k <= 0){
            return 0;
        }

        String key = idx+"-"+k;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int notake = helper(piles,idx+1,k);
        int take = 0;
        int sum = 0;
        for(int i = 0; i<Math.min(piles.get(idx).size(),k); i++){
            sum += piles.get(idx).get(i);
            take = Math.max(take,sum+helper(piles,idx+1,k-(i+1)));
        }
        map.put(key,Math.max(take,notake));
        return Math.max(take,notake);
    }
}