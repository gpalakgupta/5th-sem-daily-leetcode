class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int even =1;
        int sum = 0;
        int odd = 0;
        int mod = 1000000007;
        int ans = 0;
        for(int el : arr){
            sum += el;
            if(sum %2 == 0){
                ans += odd;
                even++;
            }
            else{
                ans += even;
                odd++;
            }
            ans %= mod;
        }
        return ans;
    }
}