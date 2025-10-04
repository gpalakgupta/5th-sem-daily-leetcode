class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = 0;
        int i = 0;
        int j = n-1;
        while(i<=j){
            ans = Math.max(ans,Math.min(height[i],height[j])*(j-i));
            if(height[i] > height[j]){
                j--;
            }
            else{
                i++;
            }
        }
        return ans;
    }
}