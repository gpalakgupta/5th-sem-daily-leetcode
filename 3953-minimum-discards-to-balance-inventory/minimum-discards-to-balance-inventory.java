class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        Set<Integer> discardedIdx = new HashSet<>();

        int l = 0, r = 0;
        int n = arrivals.length;
        int discard = 0;

        while (r < n) {
            int x = arrivals[r];
            freq.put(x, freq.getOrDefault(x, 0) + 1);

            // discard current arrival if exceeds limit
            if (freq.get(x) > m) {
                discard++;
                freq.put(x, freq.get(x) - 1);
                if (freq.get(x) == 0) freq.remove(x);
                discardedIdx.add(r);
            }

            // slide window
            if (r - l + 1 == w) {
                if (!discardedIdx.contains(l)) {
                    int y = arrivals[l];
                    freq.put(y, freq.get(y) - 1);
                    if (freq.get(y) == 0) freq.remove(y);
                }
                l++;
            }
            r++;
        }
        return discard;
    }
}
