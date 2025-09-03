class Solution {
    public class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int numberOfPairs(int[][] points) {
        int n = points.length;
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(points[i][0], points[i][1]);
        }
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.first != o2.first) {
                    return o1.first - o2.first;
                } else {
                    return o2.second - o1.second;
                }
            }
        });

        int result = 0;
        for (int i = 0; i < n; i++) {
            int x1 = arr[i].first;
            int y1 = arr[i].second;
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                int x2 = arr[j].first;
                int y2 = arr[j].second;
                if (y2 > y1) {
                    continue;
                }

                if (y2 > max) {
                    result++;
                    max = y2;
                }
            }
        }
        return result;
    }
}