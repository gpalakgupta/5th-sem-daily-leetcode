class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for(int i = 0; i<bookings.length; i++){
            int st = bookings[i][0];
            int end = bookings[i][1];
            int cost = bookings[i][2];
            ans[end-1] += cost;
            if(st > 1){
                ans[st-2]-=cost;
            }
        }
        for(int i = n-2; i>=0; i--){
            ans[i] += ans[i+1];
        }
        return ans;
    }
}