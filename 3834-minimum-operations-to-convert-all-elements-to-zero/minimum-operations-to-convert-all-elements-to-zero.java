class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int el : nums){
           
            while(!st.isEmpty() && st.peek() > el){
                st.pop();
            }
            if(el != 0 && (st.isEmpty() || st.peek() < el) ){
                st.push(el);
                ans++;
            }
          
            
        }
        return ans;
    }
}