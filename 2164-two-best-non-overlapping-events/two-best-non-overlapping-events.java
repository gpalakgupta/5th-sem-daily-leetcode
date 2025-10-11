class Solution {
    public class tuple {
        int first;
        int second;
        int val;

        public tuple(int first, int second, int val) {
            this.first = first;
            this.second = second;
            this.val = val;
        }
    }

    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        tuple[] arr = new tuple[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new tuple(events[i][0], events[i][1], events[i][2]);
        }
        Arrays.sort(arr, new Comparator<tuple>() {
            @Override
            public int compare(tuple o1, tuple o2) {
                return o1.first - o2.first;
            }
        });

        int[][] dp = new int[n][3];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return helper(arr, 0, 2, dp);
    }

    public int helper(tuple[] arr, int idx, int k, int[][] dp) {
        if (idx >= arr.length) {
            return 0;
        }
        if (k == 0) {
            return 0;
        }
        if (dp[idx][k] != -1) {
            return dp[idx][k];
        }

        int notake = helper(arr, idx + 1, k, dp);
        int next = nextidx(arr[idx].second, arr, idx + 1);
        int take = arr[idx].val + helper(arr, next, k - 1, dp);
        return dp[idx][k] = Math.max(take, notake);
    }

    public int nextidx(int end, tuple[] arr, int idx) {
        int l = idx, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid].first > end)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}