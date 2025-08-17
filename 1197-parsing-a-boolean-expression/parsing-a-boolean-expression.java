class Solution {
    public boolean parseBoolExpr(String expression) {
        int n = expression.length();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<n; i++){
            char ch = expression.charAt(i);
            if(ch == ','){
                continue;
            }
            else if(ch == ')'){
                List<Character> lt = new ArrayList<>();
                while(st.peek() != '('){
                    lt.add(st.pop());
                }
                st.pop();
                char op = st.pop();
                st.push(evaluate(lt,op));
            }
            else{
                st.push(ch);
            }
        }
        return st.peek() == 'f'?false:true;
    }
    public char evaluate(List<Character> lt, char op){
        if(op == '!'){
            return lt.get(0) == 'f'? 't':'f';
        }
        if(op == '|'){
            for(char ch : lt){
                if(ch == 't'){
                    return 't';
                }
            }
            return 'f';
        }
        if(op == '&'){
            for(char ch : lt){
                if(ch == 'f'){
                    return 'f';
                }
            }
            return 't';
        }
        return 't';
    }
}