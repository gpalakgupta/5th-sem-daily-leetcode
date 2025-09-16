class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int n = groupSizes.length;
        for(int i = 0; i<n; i++){
             if(!map.containsKey(groupSizes[i])){
                map.put(groupSizes[i],new ArrayList<>());
             }

             map.get(groupSizes[i]).add(i);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int key : map.keySet()){
            while(map.get(key).size() != 0){
                List<Integer> lt = new ArrayList<>();
                while(lt.size() != key){
                    lt.add(map.get(key).get(0));
                    map.get(key).remove(0);
                }
                ans.add(lt);
            }
        }
        return ans;
    }
}