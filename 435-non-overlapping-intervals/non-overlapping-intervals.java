class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return Integer.compare(a[1],b[1]);
        });
        int c = 0;
        int end = intervals[0][1];
        for(int[] el : intervals){
            if(el[0] < end){
                c++;
            }
            else{
                end = el[1];
            }
        }
        return c-1;
    }
}