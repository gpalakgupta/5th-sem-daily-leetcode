class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] arr = new int[n+1];
        for(int i = 0; i<=n; i++){
            int st = Math.max(i-ranges[i],0);
            int end = Math.min(i+ranges[i],n);
            arr[st] = Math.max(arr[st],end);
        }

        int curr = 0;
        int mx = 0;
        int taps = 0;
        for(int i = 0; i<=n; i++){
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