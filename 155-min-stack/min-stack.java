class MinStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> ht = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(val);
            ht.push(val);
        }
        else{
            if(ht.peek() > val){
                ht.push(val);
            }
            else{
                ht.push(ht.peek());
            }
            st.push(val);
        }
    }
    
    public void pop() {
        st.pop();
        ht.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
      return  ht.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */