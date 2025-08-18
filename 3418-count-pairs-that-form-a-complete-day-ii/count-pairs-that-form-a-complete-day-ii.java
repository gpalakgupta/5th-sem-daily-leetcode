class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int el : hours){
            int rem = el%24;
            int need = (24-rem)%24;
            if(map.containsKey(need)){
                ans+=map.get(need);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return ans;
    }
}