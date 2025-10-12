class Solution {
    public class Pair{
        String first;
        int second;
        public Pair(String first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startGene,0));
        HashSet<String> st = new HashSet<>();
        for(String el : bank){
            st.add(el);
        }
        char[] ch = {'A','C','G','T'};
        while(!q.isEmpty()){
            Pair rv = q.poll();
            String str = rv.first;
            int steps = rv.second;
            if(str.equals(endGene)){
                return steps;
            }
            for(int i = 0; i<str.length(); i++){
                for(int j = 0; j<4; j++){
                    char[] charr = str.toCharArray();
                    charr[i] = ch[j];
                    String newstr = new String(charr);
                    if(st.contains(newstr)){
                        q.add(new Pair(newstr,steps+1));
                        st.remove(newstr);
                    }
                }
            }
        }
        return -1;
    }
}