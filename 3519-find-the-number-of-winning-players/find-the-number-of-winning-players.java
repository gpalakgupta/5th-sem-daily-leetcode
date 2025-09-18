class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i = 0; i<pick.length; i++){
            int a = pick[i][0];
            int b = pick[i][1];
            if(!map.containsKey(a)){
                map.put(a,new HashMap<>());
            }
            map.get(a).put(b,map.get(a).getOrDefault(b,0)+1);
        }

        int ans = 0;
        for(int key : map.keySet()){
            for(int ball : map.get(key).keySet()){
                if(map.get(key).get(ball) >= key+1){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}