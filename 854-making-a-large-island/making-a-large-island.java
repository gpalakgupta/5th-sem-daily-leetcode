class Solution {
    public class Node{
        int val;
        int rank;
        int size;
        Node parent;
    }
    HashMap<Integer,Node> mp = new HashMap<>();
    public void createSet(int v1){
        Node nn = new Node();
        nn.val = v1;
        nn.rank = 0;
        nn.size = 1;
        nn.parent = nn;
        mp.put(v1,nn);
    }
    public int find(int v1){
        Node nn = mp.get(v1);
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
    public void unionByRank(int v1, int v2){
        Node nn1 = mp.get(v1);
        Node nn2 = mp.get(v2);
        Node rn1 = find(nn1);
        Node rn2 = find(nn2);
        if(rn1 == rn2){
            return;
        }
        if(rn1.rank == rn2.rank){
            rn2.parent = rn1;
            rn1.rank++;
        }
        else if(rn1.rank > rn2.rank){
            rn2.parent = rn1;
        }
        else{
            rn1.parent = rn2;
        }
    }

    public void unionBySize(int v1, int v2){
        Node nn1 = mp.get(v1);
        Node nn2 = mp.get(v2);
        Node rn1 = find(nn1);
        Node rn2 = find(nn2);
        if(rn1 == rn2){
            return;
        }
        if(rn1.size == rn2.size){
            rn2.parent = rn1;
            rn1.size+=rn2.size;
        }
        else if(rn1.rank > rn2.rank){
            rn2.parent = rn1;
            rn1.size+=rn2.size;

        }
        else{
            rn1.parent = rn2;
            rn2.size+=rn1.size;

        }
    }
    public boolean isValid(int cr, int cc, int n){
        return cr >= 0 && cc >= 0 && cr < n && cc < n;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        for(int i = 0; i<n*n; i++){
            createSet(i);
        }
        int[] r = {0,-1,0,1};
        int[] c = {-1,0,1,0};
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 0){
                    continue;
                }
                for(int k = 0; k<4; k++){
                    int cr = i+r[k];
                    int cc = j+c[k];
                    if(isValid(cr,cc,n)){
                        if(grid[cr][cc] == 1){
                            int nodeNo = i*n+j;
                            int cNodeNo = cr*n+cc;
                            unionBySize(nodeNo,cNodeNo);
                        }
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                    continue;
                }
                HashSet<Integer> st = new HashSet<>();
                for(int k = 0; k<4; k++){
                    int cr = i+r[k];
                    int cc = j+c[k];
                    if(isValid(cr,cc,n)){
                        if(grid[cr][cc] == 1){
                            st.add(find(cr*n+cc));
                        }
                    }
                }
                int total = 0;
                for(int el : st){
                    total += mp.get(el).size;
                }
                ans = Math.max(ans,total+1);
            }
        }
        for(int i = 0; i<n; i++){
            ans = Math.max(ans,find(mp.get(i)).size);
        }
        return ans;
    }
}