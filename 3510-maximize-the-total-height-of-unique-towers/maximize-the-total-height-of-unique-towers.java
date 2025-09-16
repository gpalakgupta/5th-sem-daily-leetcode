class Solution {
    public void rev(int[] maximumHeight){
        int i = 0;
        int j = maximumHeight.length-1;
        while(i<j){
            int t = maximumHeight[i];
            maximumHeight[i] = maximumHeight[j];
            maximumHeight[j] = t;
            i++;
            j--;
        }
    }
    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        rev(maximumHeight);
        for(int i = 1; i<maximumHeight.length; i++){
            maximumHeight[i] = Math.min(maximumHeight[i],maximumHeight[i-1]-1);
            if(maximumHeight[i] <= 0){
                return -1;
            }
        }
        long sum = 0;
        for(int el : maximumHeight){
            sum+=el;
        }
        return sum;
    }
}