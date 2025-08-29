class Solution {
    public long flowerGame(int n, int m) {
        return ((n+1L)/2) * (m/2L) + ((n/2L)*((m+1L)/2));
    }
}