class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n+1];
        int i1 = 1;
        int i2 = 1;
        int i3 = 1;
        arr[1] = 1;
        for(int i = 2; i<=n; i++){
            int t1 = arr[i1]*2;
            int t2 = arr[i2]*3;
            int t3 = arr[i3]*5;
            int min = Math.min(t1,Math.min(t2,t3));
            arr[i] = min;
            if(min == t1){
                i1++;
            }
            if(min == t2){
                i2++;
            }
            if(min == t3){
                i3++;
            }
        }
        return arr[n];
    }
}