class Solution {
    public class Node{
        int val;
        int rank;
        Node parent;
    }
    HashMap<Integer,Node> map = new HashMap<>();
    public void createSet(int val){
        Node nn = new Node();
        nn.val = val;
        nn.rank = 0;
        nn.parent = nn;
        map.put(val,nn);
    }
    public int find(int val){
        Node nn = map.get(val);
        return find(nn).val;
    }
    public Node find(Node nn){
        if(nn.parent == nn){
            return nn;
        }
        Node rn = find(nn.parent);
        nn.parent = rn;
        return rn;
    }
    public void union(int v1, int v2){
        Node n1 = map.get(v1);
        Node n2 = map.get(v2);
        Node rn1 = find(n1);
        Node rn2 = find(n2);
        if(rn1.rank == rn2.rank){
            rn1.parent = rn2;
            rn2.rank++;
        }
        else if(rn1.rank < rn2.rank){

            rn2.parent = rn1;
        }
        else{
            rn1.parent = rn2;
        }
    }
    public boolean isvalid(int cr, int cc, int n, int m){
        return (cr >= 0 && cc >= 0 && cr < n && cc < m);
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i<n*m; i++){
            createSet(i);
        }

        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == '0'){
                    continue;
                }
                cnt++;
                int[] r = {0,-1,0,1};
                int[] c = {-1,0,1,0};
                for(int k = 0; k<3; k++){
                    int cr = i+r[k];
                    int cc = j+c[k];
                    if(isvalid(cr,cc,n,m) && grid[cr][cc] == '1'){
                        int nodeno = i*m+j;
                        int cnodeno = cr*m+cc;
                        if(find(nodeno) != find(cnodeno)){
                            cnt--;
                            union(nodeno,cnodeno);
                        }
                    }
                }
            }
        }
        return cnt;
    }
}