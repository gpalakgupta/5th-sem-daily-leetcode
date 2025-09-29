class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[m];
        int ans = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(matrix[i][j] == '0'){
                    arr[j] = 0;
                }
                else{
                    arr[j]++;
                }
            }
            ans = Math.max(ans,larget(arr));
        }
        return ans;
    }
    public int larget(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                int h = arr[st.pop()];
                int r = i;
                if(st.isEmpty()){
                    ans = Math.max(ans,r*h);
                }
                else{
                    int l = st.peek();
                    int area = h*(r-l-1);
                     ans = Math.max(ans,area);
                }
            }
            st.push(i);
        }
        int r = arr.length;
         while(!st.isEmpty()){
                int h = arr[st.pop()];
                if(st.isEmpty()){
                    ans = Math.max(ans,r*h);
                }
                else{
                    int l = st.peek();
                    int area = h*(r-l-1);
                    ans = Math.max(ans,area);
                }
            }
            return ans;
    }
}