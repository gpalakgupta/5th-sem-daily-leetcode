class Solution {
    HashMap<String,Integer> map = new HashMap<>();
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        map.clear();
        return helper(piles,0,k);
    }
    public int helper(List<List<Integer>> piles, int idx, int k){
        if(idx >= piles.size()){
            return 0;
        }
        int taken = 0;
        String key = idx+"-"+k;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int notaken = helper(piles,idx+1,k);
        int sum = 0;
        for(int j = 0; j<Math.min(piles.get(idx).size(),k); j++){
            sum += piles.get(idx).get(j);
            taken = Math.max(taken,sum + helper(piles,idx+1,k-(j+1)));
        }
        int res =  Math.max(taken,notaken);
        map.put(key,res);
        return res;
    }
}