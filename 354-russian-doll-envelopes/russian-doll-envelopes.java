class Solution {
    public class Pair{
        int h;
        int w;
        public Pair(int h, int w){
            this.h = h;
            this.w = w;
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Pair[] arr = new Pair[n];
        for(int i = 0; i<n; i++){
            arr[i] = new Pair(envelopes[i][0],envelopes[i][1]);
        }
        Arrays.sort(arr, new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2){
                if(o1.w == o2.w){
                    return o2.h-o1.h;
                }
                return o1.w-o2.w;
            }
        });

        return helper(arr,n);
    }
    public int helper(Pair[] arr, int n){
        Pair[] dp = new Pair[n];
        dp[0] = new Pair(arr[0].h,arr[0].w);
        int len = 1;
        for(int i = 1; i<n; i++){
            if(dp[len-1].h < arr[i].h){
                dp[len] = new Pair(arr[i].h,arr[i].w);
                len++;
            }
            else{
                int idx = search(arr[i].h,dp,0,len);
                dp[idx] = new Pair(arr[i].h,arr[i].w);
            }
        }
        return len;
    }

    public int search(int el , Pair[] dp, int st, int end){
        int ans = -1;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(dp[mid].h >= el){
                ans = mid;
                end = mid-1;
            }
            else{
                st = mid+1;
            }
        }
        return ans;
    }
}