class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int el : time){
            int rem = el%60;
            int need = (60-rem)%60;
            if(map.containsKey(need)){
                ans+=map.get(need);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return ans;
    }
}