class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];
        
        for(int el : arr){
            int mod = (el % k + k) % k;
            freq[mod]++;
        }

        if(freq[0] % 2 != 0) return false;

        for(int i = 1; i <= k/2; i++){
            if(i == k - i){
                if(freq[i] % 2 != 0) return false;
            } else {
                if(freq[i] != freq[k - i]) return false;
            }
        }

        return true;
    }
}
