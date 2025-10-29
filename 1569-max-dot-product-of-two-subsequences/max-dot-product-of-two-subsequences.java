class Solution {
    int n1;
    int n2;
    HashMap<String, Integer> map = new HashMap<>();

    public int maxDotProduct(int[] nums1, int[] nums2) {
        n1 = nums1.length;
        n2 = nums2.length;
        map.clear();
        return helper(nums1, nums2, 0, 0);
    }

    public int helper(int[] nums1, int[] nums2, int i, int j) {
        if (i >= n1 || j >= n2) {
            return -(int)(1e9);
        }
        String key  = i+"-"+j;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int take1 = nums1[i] * nums2[j] + Math.max(0,helper(nums1,nums2,i+1,j+1));
        int notake1 = helper(nums1, nums2, i+1,j);
        int notake2 = helper(nums1, nums2, i,j+1);
        int ans = Math.max(take1,Math.max(notake1,notake2));
        map.put(key,ans);
        return ans;
    }
}