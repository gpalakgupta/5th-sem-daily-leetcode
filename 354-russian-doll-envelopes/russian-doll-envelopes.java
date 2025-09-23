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
        Arrays.sort(arr,new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2){
                if(o1.w == o2.w){
                    return o2.h - o1.h;
                }
                return o1.w - o2.w;
            }
        });
        return helper(arr);

        // int[] dp =  new int[n];
        // int max = 0;
        // for(int i = 0; i<n; i++){
        //     int mx = 0;
        //     for(int j = 0; j<i; j++){
        //         if(arr[j].h < arr[i].h ){
        //             if(dp[j] > mx){
        //                 mx = dp[j];
        //             }
        //         }
        //     }
        //     dp[i] = mx+1;
        //     if(dp[i] > max){
        //         max = dp[i];
        //     }
        // }
        // return max;
    }
    public int helper(Pair[] nums){
        Pair[] dp = new Pair[nums.length];
        dp[0] = new Pair(nums[0].h,nums[0].w);
        int len = 1;
        for(int i =1; i<nums.length; i++){
            if(nums[i].h > dp[len-1].h ){
                dp[len] = new Pair(nums[i].h,nums[i].w);
                len++;
            }
            else{
                int idx = search(dp,0,len,nums[i]);
                dp[idx] = new Pair(nums[i].h,nums[i].w);
                
            }
        }
        return len;
    }
    public int search(Pair[] dp, int st, int end, Pair item){
        int ans = 0;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(dp[mid].h >= item.h  ){
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