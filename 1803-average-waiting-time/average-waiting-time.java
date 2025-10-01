class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        long ans = 0;
        long cheftime = 0;
        long res = 0;
        for(int[] arr : customers){
            int a = arr[0];
            int b = arr[1];
            cheftime = Math.max(cheftime,a);
            // System.out.println(cheftime);
            cheftime = cheftime+b;
            // System.out.println(ans);
            
            res += cheftime-a;
        }
        return res*1.0/n;
    }
}