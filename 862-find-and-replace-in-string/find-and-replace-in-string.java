class Solution {
    public class Pair{
        int idx;
        int el;
        public Pair(int idx, int el){
            this.idx = idx;
            this.el = el;
        }
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        String ans = "";
        int k = 0;
        int m = indices.length;

        Pair[] arr = new Pair[m];
        for(int i = 0; i < m; i++){
            arr[i] = new Pair(i, indices[i]);
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a.el, b.el));

        for(int i = 0; i < m; i++){
            int srcIdx = arr[i].idx;
            int idx = arr[i].el;
            int n = sources[srcIdx].length();

            
            if(idx < k) continue;

            if(k < idx){
                ans += s.substring(k, idx);
            }

            if(idx + n <= s.length() && s.substring(idx, idx + n).equals(sources[srcIdx])){
                ans += targets[srcIdx];
                k = idx + n;
            } else {
                k = idx;
            }
        }

        if(k < s.length()){
            ans += s.substring(k);
        }

        return ans;
    }
}
