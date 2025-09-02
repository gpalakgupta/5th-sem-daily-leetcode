class Solution {
    public void setZeroes(int[][] arr) {
        int n = arr.length;
        int m =  arr[0].length;
        int[] col = new int[m];
        int [] row =  new int[n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(arr[i][j] == 0){
                    col[j] = 1;
                    row[i] = 1;
                }
            }
        }
             for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(row[i] == 1  || col[j] == 1)arr[i][j] = 0;
           
        } 

    }
}
}
