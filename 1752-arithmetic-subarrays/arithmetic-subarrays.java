class Solution {
    public boolean helper(int[] nums, int k, int j){
        int[] arr = new int[j-k+1];
        int idx = 0;
        for(int i = k; i<=j; i++){
            arr[idx++] = nums[i];
        }
        Arrays.sort(arr);
        int diff = arr[1]-arr[0];
        for(int i = 1; i<arr.length; i++){
            if(arr[i]-arr[i-1] != diff){
                return false;
            }
        }
        return true;
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0; i<l.length; i++){
            if(helper(nums,l[i],r[i])){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }
}