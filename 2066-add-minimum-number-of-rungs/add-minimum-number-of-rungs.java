class Solution {
    public int addRungs(int[] rungs, int dist) {
        int c = 0;
        int ht = 0;
        for(int i = 0; i<rungs.length; i++){
            if(rungs[i]-ht > dist){ 
                c+= (rungs[i]-ht-1)/dist;
            }
            ht = rungs[i];
        }
        return c;
    }
}