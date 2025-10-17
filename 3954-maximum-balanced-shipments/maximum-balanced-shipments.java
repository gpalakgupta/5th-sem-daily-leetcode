class Solution {
    public int maxBalancedShipments(int[] weight) {
        int n = weight.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int mx = weight[i];
            boolean f = false;
            for (int j = i + 1; j < n; j++) {
                mx = Math.max(mx, weight[j]);

                if (weight[j] < mx) {
                    cnt++;
                    i = j ;
                    f = true;
                    break;
                }
            }
            if (!f) {
                break;
            }
        }
        return cnt;
    }
}
