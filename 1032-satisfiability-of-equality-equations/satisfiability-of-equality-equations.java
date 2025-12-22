class Solution {
    public class Node{
        char val;
        int rank;
        Node parent;
    }
    HashMap<Character,Node> map = new HashMap<>();
    public void createSet(char v){
        Node nn = new Node();
        nn.val = v;
        nn.rank = 0;
        nn.parent = nn;
        map.put(v,nn);
    }

    public int find(char v){
        Node nn = map.get(v);
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

    public void union(char v1, char v2){
        Node nn1 = map.get(v1);
        Node nn2 = map.get(v2);
        Node rn1 = find(nn1);
        Node rn2 = find(nn2);
        if(rn1.rank == rn2.rank){
            rn1.parent = rn2;
            rn2.rank++;
        }
        else if(rn1.rank > rn2.rank){
            rn2.parent = rn1;
        }
        else{
            rn1.parent = rn2;
        }
    }

    public boolean equationsPossible(String[] equations) {
        HashMap<Character,List<Character>> mp = new HashMap<>();
        for(char ch = 'a'; ch <='z'; ch++){
            createSet(ch);
            mp.put(ch,new ArrayList<>());
        }
        int n = equations.length;
        for(int i = 0; i<n; i++){
            if(equations[i].charAt(1) == '='){
                union(equations[i].charAt(0),equations[i].charAt(3));
            }
            else{
                mp.get(equations[i].charAt(0)).add(equations[i].charAt(3));
            }
        }

        for(char ch : mp.keySet()){
            for(char el : mp.get(ch)){
                if(find(el) == find(ch)){
                    return false;
                }
            }
        }
        return true;
    }
}