class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        for(int el : nums){
            st.add(el);
        }
        int i = 0;
        for(int el : nums){
            if(st.contains(el)){
                nums[i++] = el;
                st.remove(el);
            }
        }
        return i;
    }
}