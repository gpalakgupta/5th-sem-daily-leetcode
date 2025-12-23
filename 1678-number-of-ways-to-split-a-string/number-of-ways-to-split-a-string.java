class Solution {
    public int numWays(String s) {
        int sum = 0;
        char[] ch = s.toCharArray();
        int n = s.length();
        for(char el : ch){
            if(el == '1'){
                sum++;
            }
        }
        if(sum % 3 != 0){
            return 0;
        }
        if(sum == 0){
            return (int)(((long)(n-1)*(n-2)/2)%1000000007);
        }
       
        int target = sum / 3;
        int count = 0;
        long ways1 = 0, ways2 = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') count++;
            if (count == target) ways1++;
            if (count == 2 * target) ways2++;
        }

        return (int)((ways1 * ways2) % 1000000007);
    }
}