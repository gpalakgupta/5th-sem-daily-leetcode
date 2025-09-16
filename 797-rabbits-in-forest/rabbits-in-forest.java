class Solution {
    public int numRabbits(int[] answers) {
        int n = answers.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int el : answers){
            map.put(el,map.getOrDefault(el,0)+1);
        }

        int ans = 0;
        for(int key : map.keySet()){
            int count = map.get(key);
            int grpSize = key+1;

            int totalelments = (count+grpSize-1)/grpSize;
             ans += totalelments*grpSize;
        }

        return ans;

    }
}