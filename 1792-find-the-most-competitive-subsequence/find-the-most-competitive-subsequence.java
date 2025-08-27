class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && st.size() - 1 + (nums.length - i) >= k && nums[i] < nums[st.peek()]) {
                st.pop();
            }
            if (st.size() < k) {
                st.push(i);
            }
        }
        int i = k - 1;
        while (!st.isEmpty()) {
            ans[i--] = nums[st.pop()];
        }
        return ans;
    }
}