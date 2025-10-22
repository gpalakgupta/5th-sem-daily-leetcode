class Solution {
    public int calculate(String s) {
     Stack<Integer> st = new Stack<>();
     Stack<Character> op = new Stack<>();
     for(int i = 0; i<s.length(); i++){
        char ch = s.charAt(i);
        if(Character.isDigit(ch)){
            int n = 0;
            while(i<s.length() && (Character.isDigit(s.charAt(i)))){
                n = n*10+(s.charAt(i) - '0');
                i++;
            }
            i--;
            st.push(n);
        }
        else if(ch == ' '){
            continue;
        }
        else if(op.size() == 0){
            op.push(ch);
        }
        else if(ch == '+' || ch == '-'){
            while(op.size() != 0 && (op.peek() == '+' || op.peek() == '*' || op.peek() == '-' || op.peek() == '/')){
                int v2 = st.pop();
                int v1 = st.pop();
                if(op.peek() == '+'){
                    st.push(v1+v2);
                }
                if(op.peek() == '-'){
                    st.push(v1-v2);
                }
                if(op.peek() == '*'){
                    st.push(v1*v2);
                }
                if(op.peek() == '/'){
                    st.push(v1/v2);
                }
                op.pop();
            }
            op.push(ch);
        }
        else if(ch == '*' || ch == '/'){
            while(op.size() != 0 && (op.peek() == '*'|| op.peek() == '/')){
                int v2 = st.pop();
                int v1 = st.pop();
                if(op.peek() == '*'){
                    st.push(v1*v2);
                }
                if(op.peek() == '/'){
                    st.push(v1/v2);
                }
                op.pop();
            }
            op.push(ch);
        }
    }
    while(op.size() != 0){
        int v2 = st.pop();
        int v1 = st.pop();
        if(op.peek() == '+'){
                st.push(v1+v2);
                }
                if(op.peek() == '-'){
                    st.push(v1-v2);
                }
                if(op.peek() == '*'){
                    st.push(v1*v2);
                }
                if(op.peek() == '/'){
                    st.push(v1/v2);
                }
                op.pop();
            }
    
      return st.peek();
    }
}