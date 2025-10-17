class Solution {
    public int findTheWinner(int n, int k) {
        return helper(n,k)+1;
        // Queue<Integer> q = new LinkedList<>();
        // for(int i = 1; i<=n; i++){
        //     q.add(i);
        // }

        // while(q.size() > 1){
        //     for(int i = 0; i<k-1; i++){
        //         q.add(q.remove());
        //     }
        //     q.remove();
        // }
        // return q.remove();
    }
    public int helper(int n, int k){
        if(n == 0){
            return 0;
        }
        int idx = helper(n-1,k);
        idx = (idx+k)%n;
        return idx;
    }
}