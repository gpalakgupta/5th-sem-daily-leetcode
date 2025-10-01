class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for(int i = 0; i<gas.length; i++){
            sum += gas[i]-cost[i];
        }
        if(sum < 0){
            return -1;
        }
        int i = 0;
        sum = 0;
        int ans = 0;
        while(i<gas.length){
            sum += gas[i]-cost[i];
            if(sum < 0){
                ans = i+1;
                sum = 0;
            }
            i++;
        }
        return ans;
    }
}