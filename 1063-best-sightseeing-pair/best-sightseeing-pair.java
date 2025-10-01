class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int mx = 0;
        int mxsum = values[0];
        for(int i = 1; i<n; i++){
            mx = Math.max(mx,mxsum+values[i]-i);
            mxsum = Math.max(mxsum,values[i]+i);

        }
        return mx;
    }
}