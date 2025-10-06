class StockSpanner {
    Stack<Integer> st = new Stack<>();
    List<Integer> ll = new ArrayList<>();
    int idx = -1;
    public StockSpanner() {
        st.clear();
        ll.clear();
        idx = -1;
    }
    
    public int next(int price) {
        idx = idx+1;
        while(!st.isEmpty() && ll.get(st.peek()) <= price){
            st.pop();
        }
        int ans = idx-(st.isEmpty() ? -1 : st.peek());
        ll.add(price);
        st.push(ll.size()-1);
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */