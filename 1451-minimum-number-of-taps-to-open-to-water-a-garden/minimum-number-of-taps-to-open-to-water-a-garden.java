class Solution {
    public int minTaps(int n, int[] ranges) {
        int N = ranges.length;
        int[] arr = new int[n+1];
        for(int i = 0; i<N; i++){
           int st = Math.max(0,i-ranges[i]);
           int end = Math.min(n,i+ranges[i]);
           arr[st] = Math.max(arr[st],end);
        }
        int curr = 0;
        int taps = 0;
        int mx = 0;
        for(int i = 0; i<N; i++){
            if(i > mx){
                return -1;
            }
            if(i > curr){
                taps++;
                curr = mx;
            }
            mx = Math.max(mx,arr[i]);
        }
        return taps;
    }
}