class Solution {
    public void trans(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }
            }
        }
    }

    public void rotate(int[][] matrix) {
        trans(matrix);
        int n = matrix.length;
        for(int i = 0; i<n; i++){
            reverse(matrix[i]);
        }
    }
    public void reverse(int[] arr){
        int i = 0;
        int j = arr.length-1;
        while(i<j){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }
}