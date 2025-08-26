class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        int ans = Integer.MIN_VALUE;
        int dia = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int a = dimensions[i][0];
            int b = dimensions[i][1];
            int power = a*a+b*b;
            if (power == ans) {
                dia = Math.max(dia, a * b);
            }
            else if (power > ans) {
                ans = power;
                dia = a * b;
            }

        }
        return dia;
    }
}