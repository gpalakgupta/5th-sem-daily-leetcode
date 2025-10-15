class Solution {
    public class tuple {
        int first;
        int second;
        int cost;

        public tuple(int first, int second, int cost){
            this.first = first;
            this.second = second;
            this.cost = cost;
        }
    }

    public long maxTaxiEarnings(int n, int[][] rides) {
        int N = rides.length;
        tuple[] arr = new tuple[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new tuple(rides[i][0], rides[i][1], rides[i][2]);
        }

        Arrays.sort(arr, new Comparator<tuple>() {
            @Override
            public int compare(tuple o1, tuple o2) {
               return o1.first - o2.first;
            }
        });
        long[] dp = new long[N+1];
        Arrays.fill(dp,-1);
        return helper(arr, 0,dp);
    }

    public long helper(tuple[] arr, int idx, long[] dp){
        if(idx >= arr.length){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        int next = get(arr,idx+1,arr[idx].second);
        long take = (long)(arr[idx].second - arr[idx].first  + arr[idx].cost) + helper(arr,next,dp);
        long notake = helper(arr,idx+1,dp);
        return dp[idx] = Math.max(take,notake);
    }

    public int get(tuple[] arr, int idx, int el) {
        int st = idx;
        int end = arr.length-1;
        int ans = arr.length;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(arr[mid].first >= el){
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