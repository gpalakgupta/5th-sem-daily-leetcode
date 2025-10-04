class Solution {
    public int maximumTastiness(int[] price, int k) {
        int n = price.length;
        Arrays.sort(price);
        int st = 0;
        int end = price[n-1]-price[0];
        int ans = 0;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(isvalid(price,k,mid)){
                ans = mid;
                st = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
    public boolean isvalid(int[] price, int k , int mid){
        int c = 1;
        int i = 1;
        int st = price[0];
        while(i<price.length){
            if(price[i]-st >= mid){
                c++;
                st = price[i];
            }
            i++;
            if(c >= k){
                return true;
            }
        }
        return false;
    }
}