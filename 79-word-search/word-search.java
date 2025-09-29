class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean ans = helper(board,i,j,n,m,0,word);
                    if(ans){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board, int cr, int cc, int er, int ec,int idx, String word){
        if(idx == word.length()){
            return true;
        }
        if (cr < 0 || cc < 0 || cr >= er || cc >= ec || board[cr][cc] != word.charAt(idx)){
            return false;
        }

        int[] r= {0,-1,0,1};
        int[] c = {-1,0,1,0};
        char temp = board[cr][cc];
        board[cr][cc] = '#';
        for(int i = 0; i<4; i++){
            int row = cr+r[i];
            int col = cc+c[i];
            boolean ans = helper(board,row,col,er,ec,idx+1,word);
            if(ans){
                return ans;
            }
        }
        board[cr][cc] = temp;
        return false;
    }
}