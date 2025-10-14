class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indeg = new int[n + 1];
        int[] outdeg = new int[n + 1];

        for (int[] arr : trust) {
            int a = arr[0];
            int b = arr[1];
            indeg[b]++;
            outdeg[a]++;
        }
        // for(int el : indeg){
        //     System.out.print(el+" ");
        // }
        // System.out.println();
        // for(int el : outdeg){
        //     System.out.print(el+" ");
        // }
        // System.out.println();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == n-1 && outdeg[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}