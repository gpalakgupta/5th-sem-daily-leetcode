import java.math.BigInteger;

class Solution {
    public class Pair {
        int st;
        int end;

        public Pair(int st, int end) {
            this.st = st;
            this.end = end;
        }
    }

    int mod = 1000000007;

    public int numberOfGoodPartitions(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int el = nums[i];
            if (!map.containsKey(el)) {
                map.put(el, new int[2]);
                Arrays.fill(map.get(el), -1);
            }
            if (map.get(el)[0] == -1) {
                map.get(el)[0] = i;
            }
            map.get(el)[1] = i;
        }
        int n = map.size();
        Pair[] arr = new Pair[n];
        int i = 0;
        for (int key : map.keySet()) {
            arr[i] = new Pair(map.get(key)[0], map.get(key)[1]);

            i++;
        }
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.st - o2.st;
            }
        });
        int c = 1;
        int end = arr[0].end;
        i = 1;
        while (i < n) {
            if (arr[i].st > end) {
                c = (c + 1) % mod;
                end = arr[i].end;
            } else {
                end = Math.max(end, arr[i].end);
            }
            i++;
        }

        // return BigInteger.valueOf(2)
        //         .modPow(BigInteger.valueOf(c - 1), BigInteger.valueOf(mod))
        //         .intValue();

        return BigInteger.valueOf(2).modPow(BigInteger.valueOf(c-1),BigInteger.valueOf(mod)).intValue();
    }
}