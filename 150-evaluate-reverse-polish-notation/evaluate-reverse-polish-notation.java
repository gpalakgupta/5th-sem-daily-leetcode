class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<String> st = new Stack<>();
        for(int i = 0;  i<tokens.length; i++){
            int ans = 0;
            String ch = tokens[i];
            if(ch.equals("+") ||ch.equals("-") || ch.equals("*") || ch.equals("/")){
                int p2 = Integer.parseInt(st.pop());
                int p1 = Integer.parseInt(st.pop());
                if(ch.equals("+")){
                    ans+=p1+p2;
                }
                else if(ch.equals("-")){
                    ans+=p1-p2;
                }
                else if(ch.equals("*")){
                    ans+=p1*p2;
                }
                else{
                    ans+=p1/p2;
                }
                st.push(Integer.toString(ans));
            }
            else{
                st.push(ch);
            }
        }
        return Integer.parseInt(st.pop());
    }
}