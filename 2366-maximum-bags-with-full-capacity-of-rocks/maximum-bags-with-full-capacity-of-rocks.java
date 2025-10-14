class Solution {
    public class Pair{
        int a;
        int b;
        int diff;
        public Pair(int a, int b){
            this.a = a;
            this.b = b;
            this.diff = Math.abs(a-b);
        }
    }
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        Pair[] arr = new Pair[n];
        for(int i = 0; i<n; i++){
            arr[i] = new Pair(capacity[i],rocks[i]);
        }
        Arrays.sort(arr,new Comparator<>(){
            @Override
            public int compare(Pair o1, Pair o2){
                return o1.diff - o2.diff;
            }
        });
        int c = 0;
        for(int i = 0; i<n; i++){
            Pair rv = arr[i];
            int a = rv.a;
            int b = rv.b;
            int diff = rv.diff;
            if(diff <= additionalRocks){
                additionalRocks-=diff;
                c++;
            }
        }
        return c;
    }
}