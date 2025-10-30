class Solution {
    public int smallestNumber(int n) {
        int m = 1;
        while(m < n){
            m = m*2+1;
        }
        return m;
    }
}