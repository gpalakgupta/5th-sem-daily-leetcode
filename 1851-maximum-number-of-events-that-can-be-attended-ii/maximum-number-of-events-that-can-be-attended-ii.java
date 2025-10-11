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

    HashMap<String, Integer> map = new HashMap<>();

    public int maxValue(int[][] events, int k) {
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

        map.clear();
        return helper(arr, 0, k);
    }

    public int helper(tuple[] arr, int idx, int k) {
        if (idx >= arr.length) {
            return 0;
        }
        if (k == 0) {
            return 0;
        }
        String key = idx + "-" + k;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int notake = helper(arr, idx + 1, k);
        int next = nextidx(arr[idx].second, arr, idx + 1);
        int take = arr[idx].val + helper(arr, next, k - 1);
        int ans = Math.max(take, notake);
        map.put(key, ans);
        return ans;
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