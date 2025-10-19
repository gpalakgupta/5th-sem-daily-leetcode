class Solution {
    public int reverse(int x) {
        long ans = 0;
        long d = Math.abs(x);
        while(d != 0){
            long i = d%10;
            ans = ans*10+i;
            d/=10;
        }
        if(ans<Integer.MIN_VALUE || ans>Integer.MAX_VALUE){
            return 0;
        }
        return (x>0)?(int)ans:-(int)ans;
    }
}