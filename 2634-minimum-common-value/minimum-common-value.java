class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> st = new HashSet<>();
        for(int el : nums1){
            st.add(el);
        }
        int ans = Integer.MAX_VALUE;
        for(int el : nums2){
            if(st.contains(el)){
                ans = Math.min(ans,el);
            }
        }
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}