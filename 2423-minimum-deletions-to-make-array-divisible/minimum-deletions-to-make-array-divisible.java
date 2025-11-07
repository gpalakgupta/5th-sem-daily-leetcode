class Solution {
    public int gcd(int a , int b){
        return (b == 0) ? a : gcd(b,a%b);
    }
    public int minOperations(int[] nums, int[] numsDivide) {
        int n = numsDivide.length;
        for(int i = 0; i<n-1; i++){
            int GCD = gcd(numsDivide[i],numsDivide[i+1]);
            numsDivide[i] = GCD;
            numsDivide[i+1] = GCD;
        }
        Arrays.sort(nums);
        Arrays.sort(numsDivide);
        int c = 0;
        for(int el : nums){
            if(numsDivide[0] % el == 0){
                break;
            }
            c++;
        }
        return c == nums.length ? -1 : c;
    }
}