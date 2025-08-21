class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int res = 0;
        for(int i = 0; i<n; i++){
            int[] arr = new int[m];
            Arrays.fill(arr,1);
            for(int j = i; j<n; j++){
                for(int k = 0; k<m; k++){
                    arr[k] = arr[k] & mat[j][k];
                }
                res += count(arr);
            }
        }
        return res;
    }
    public int count(int[] arr){
        int cnt  = 0;
        int subcnt = 0;
        for(int el : arr){
            if(el == 0){
                cnt = 0;
            }
            else{
                cnt++;
            }
            subcnt += cnt;
        }
        return subcnt;
    }
}