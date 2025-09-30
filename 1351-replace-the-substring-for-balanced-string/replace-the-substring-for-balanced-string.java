class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int target = n/4;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer> need = new HashMap<>();
        for(char key : map.keySet()){
            if(map.get(key) > target){
                need.put(key,map.get(key)-target);
            }
        }
        if(need.size() == 0){
            return 0;
        }
        HashMap<Character,Integer> map1 = new HashMap<>();
        int st = 0;
        int end = 0;
        int ans = Integer.MAX_VALUE;
        while(end < n){
            char ch = s.charAt(end);
            if(need.containsKey(ch)){
                map1.put(ch,map1.getOrDefault(ch,0)+1);
            }
            while(st <= end && isvalid(map1,need)){
                char t = s.charAt(st);
                ans = Math.min(ans,end-st+1);
                if(map1.containsKey(t)){
                    map1.put(t,map1.get(t)-1);
                    if(map1.get(t) == 0){
                        map1.remove(t);
                    }
                }
                st++;
            }
            end++;
        }
        return ans;
    }
    public boolean isvalid(HashMap<Character,Integer> map1, HashMap<Character,Integer> need){
        for(char ch : need.keySet()){
            if(map1.getOrDefault(ch,0) < need.get(ch)){
                return false;
            }
        }
        return true;
    }
}