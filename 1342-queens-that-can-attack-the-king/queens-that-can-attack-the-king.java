class Solution {
    public void nearestQueen(int[][] grid, int cr, int cc,HashSet<String> st){
        int r = cr;
        int c = cc;
        for(int i = cc; i<8; i++){
            if(grid[r][i] == 1){
                st.add(r+","+i);
                System.out.println(r+" "+c);

                break;
            }
        }
        for(int i = cc; i>= 0; i--){
            if(grid[r][i] == 1){   
                 st.add(r+","+i);
                System.out.println(r+" "+c);
                break;
            }
        }
        for(int i = cr; i< 8; i++){
            if(grid[i][cc] == 1){
                st.add(i+","+cc);
                System.out.println(r+" "+c);

                break;
            }
        }
        for(int i = cr; i>= 0; i--){
            if(grid[i][cc] == 1){
                st.add(i+","+cc);
                System.out.println(r+" "+c);
                 
                break;
            }
        }
        while(r >= 0 && c >= 0){
            if(grid[r][c] == 1){
                st.add(r+","+c);
                System.out.println(r+" "+c);
                
                break;
            }
            r--;
            c--;
        }
        r = cr;
        c = cc;
         while(r <8 && c <8){
            if(grid[r][c] == 1){
                st.add(r+","+c);
                System.out.println(r+" "+c);
                
                break;
            }
            r++;
            c++;
        }
        r = cr;
        c = cc;
        while(r <8 && c >=0){
            if(grid[r][c] == 1){
                st.add(r+","+c);
                System.out.println(r+" "+c);
                break;
            }
            r++;
            c--;
        }
        r = cr;
        c = cc;
        while(r >=0 && c < 8){
            if(grid[r][c] == 1){
                System.out.println(r+" "+c);
                st.add(r+","+c);
                break;
            }
            r--;
            c++;
        }
    }
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int n = queens.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<String> st = new HashSet<>();
        int[][] grid = new int[8][8];
        for(int i = 0; i<n; i++){
            int r = queens[i][0];
            int c = queens[i][1];
            grid[r][c] = 1;
        }
        nearestQueen(grid,king[0],king[1],st); 
        for(int[] a : queens){
            
            if(st.contains(a[0]+","+a[1])){
                ans.add(Arrays.asList(a[0],a[1]));
            }
        }
        return ans;
    }
}