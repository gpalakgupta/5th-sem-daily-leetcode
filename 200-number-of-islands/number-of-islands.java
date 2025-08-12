class Solution {
     public class Node {
        int val;
        int rank;
        Node parent;
    }

    HashMap<Integer, Node> map = new HashMap<>();

    public void createSet(int v) {
        Node nn = new Node();
        nn.val = v;
        nn.rank = 0;
        nn.parent = nn;
        map.put(v, nn);
    }

    public int find(int v) {
        Node nn = map.get(v);
        return find(nn).val;
    }

    public Node find(Node nn) {
        if (nn.parent == nn) {
            return nn;
        }
        Node rn = find(nn.parent);
        nn.parent = rn;
        return rn;
    }
     public void union(int v, int u){
        Node n1 = map.get(v);
        Node n2 = map.get(u);
        Node re1 = find(n1);
        Node re2 = find(n2);
        if(re1 == re2){
            return;
        }
        if(re1.rank == re2.rank){
            re2.parent = re1;
            re1.rank++;
        }
        else if(re1.rank > re2.rank){
            re2.parent = re1;
        }
        else{
            re1.parent = re2;
        }
    }
    public boolean isvalid(int cr, int cc, int n, int m){
        return cr >= 0 && cr < n && cc >= 0 && cc<m;
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i<n*m; i++){
            createSet(i);
        }
        int cnt = 0;
        for(int r = 0; r<n; r++){
            for(int c = 0; c<m; c++){
                if(grid[r][c] == '0'){
                    continue;
                }
                cnt++;
                int[] row = {0,1,0,-1};
                int[] col = {1,0,-1,0};
                for(int j = 0; j<4; j++){
                    int cr = r+row[j];
                    int cc = c+col[j];
                    if(isvalid(cr,cc,n,m) && grid[cr][cc] == '1'){
                        int nodeNo = r*m+c;
                        int cNodeno = cr*m+cc;
                        if(find(nodeNo) != find(cNodeno)){
                            cnt--;
                            union(nodeNo,cNodeno);
                        }
                    }
                }
            }
        }
        return cnt;
    }
}