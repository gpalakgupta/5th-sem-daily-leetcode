class Solution {
    public int reverse(int el) {
        int n = 0;
        while (el != 0) {
            int i = el % 10;
            n = n * 10 + i;
            el /= 10;
        }
        return n;
    }

    public int countDistinctIntegers(int[] nums) {
        int n = nums.length;
        HashSet<Integer> st = new HashSet<>();
        for (int el : nums) {
            
                st.add(reverse(el));
           
             st.add(el);

        }
        return st.size();
    }
}