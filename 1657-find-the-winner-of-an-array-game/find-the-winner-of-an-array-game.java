class Solution {
    public int getWinner(int[] arr, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(int el : arr){
            dq.addLast(el);
        }
        int n = arr.length;
        if(k >= n){
            Arrays.sort(arr);
            return arr[n-1];
        }

        int c = 0;
        int el = -1;
        while(c != k){
            int a = dq.removeFirst();
            int b = dq.removeFirst();
            int mx = Math.max(a,b);
            if(el == mx){
                c++;
            }
            else{
                el = mx;
                c = 1;
            }
            if(a>b){
                dq.addFirst(a);
                dq.addLast(b);
            }
            else{
                dq.addFirst(b);
                dq.addLast(a);
            }
        }
        return el;
    }
}