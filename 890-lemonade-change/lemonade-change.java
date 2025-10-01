class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int el : bills){
            if(el == 5){
                map.put(el,map.getOrDefault(el,0)+1);
            }
            else if(el == 10){
                if(map.containsKey(5)){
                    map.put(5,map.get(5)-1);
                    if(map.get(5) == 0){
                        map.remove(5);
                    }
                }
                else{
                    return false;
                }
                map.put(el,map.getOrDefault(el,0)+1);
            }
            else{
                int t1 = map.getOrDefault(5,0);
                int t2 = map.getOrDefault(10,0);
                if(t2 >= 1 && t1 >= 1){
                    map.put(5,map.get(5)-1);
                    if(map.get(5) == 0){
                        map.remove(5);
                    }
                    map.put(10,map.get(10)-1);
                    if(map.get(10) == 0){
                        map.remove(10);
                    }
                }
                else if(t1 >= 3){
                    map.put(5,map.get(5)-3);
                    if(map.get(5) == 0){
                        map.remove(5);
                    }
                }
                else{
                    return false;
                }
                map.put(el,map.getOrDefault(el,0)+1);
            }
        }
        return true;
    }
}