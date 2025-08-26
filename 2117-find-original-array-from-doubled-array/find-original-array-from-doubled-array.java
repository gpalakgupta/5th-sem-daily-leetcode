class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0){
            return new int[]{};
        }
        int[] ans = new int[n/2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int el : changed){
            map.put(el,map.getOrDefault(el,0)+1);
        }
        Arrays.sort(changed);
        int i = 0;
        for(int el : changed){
            if(map.get(el) == 0){
                continue;
            }
            if(el == 0 && map.get(el) % 2 != 0){
                return new int[]{};
            }
            int need = el*2;
            if(!map.containsKey(need) || map.get(need) == 0){
                return new int[]{};
            }
            ans[i++] = el;
            map.put(el,map.get(el)-1);
            map.put(need,map.get(need)-1);
        }
        return ans;
    }
}