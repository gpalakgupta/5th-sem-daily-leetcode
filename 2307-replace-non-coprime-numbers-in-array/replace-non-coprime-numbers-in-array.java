class Solution {
    public int gcd(int n1, int n2){
        while(n2 != 0){
            int temp = n2;
            n2 = n1%n2;
            n1 = temp;
        }
        return n1;
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> lt = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<nums.length; i++){
            int num = nums[i];
            while(!st.isEmpty()){
                int el = st.peek();
                int GCD = gcd(el,num);
                if(GCD <= 1){
                    break;
                }
                st.pop();
                int lcm = el/GCD*num;
                num = lcm;
            }
            st.push(num);
        }
        while(!st.isEmpty()){
            lt.add(st.pop());
        }
        Collections.reverse(lt);
        return lt;
    }
}