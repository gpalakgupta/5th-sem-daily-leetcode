class Solution {
    public void longestPrefixSuffix(int[] pattern, int[] lps){
        int m = pattern.length;
        int len = 0;
        lps[0] = 0;
        int i = 1;
        while(i<m){
            if(pattern[i]== pattern[len]){
                lps[i] = len+1;
                len++;
                i++;
            }
            else{
                if(len != 0){
                    len = lps[len-1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;
        int[] nums2 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                nums2[i] = 1;
            } else if (nums[i] > nums[i + 1]) {
                nums2[i] = -1;
            } else {
                nums2[i] = 0;
            }
        }

        int[] lps = new int[m];
        longestPrefixSuffix(pattern,lps);

        int i = 0;
        int j = 0;
        int result = 0;
        while(i < nums2.length){
            if(pattern[j] == nums2[i]){
                i++;
                j++;
            }
            if(j == pattern.length){
                result++;
                j = lps[j-1];
            }
            else if(i < nums2.length && pattern[j] != nums2[i]){
                 if(j != 0){
                    j = lps[j-1];
                 }
                 else{
                    i++;
                 }
            }
        }
        return result;

    }
}