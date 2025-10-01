class Solution {
    public int longestString(int x, int y, int z) {
        int min = Math.min(x,y);
        int ans = 0;
        ans += min*2;
        ans += z*2;
        if(x == min){
            ans += Math.min(x+1,y)*2;
        }
        else{
            ans += Math.min(y+1,x)*2;
        }
        return ans;
    }
}