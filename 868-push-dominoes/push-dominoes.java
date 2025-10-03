class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] arr = dominoes.toCharArray();
        int[] force = new int[n];
        int f = 0;
        for (int i = 0; i < n ; i++) {
            char ch = arr[i];
            if (ch == 'R') {
                f = n;
            }
            else if(ch == 'L'){
                f = 0;
            } else {
                f = Math.max(f-1,0);
            }
            force[i] += f;
        }
        f = 0;
        for (int i = n-1; i >= 0; i--) {
            char ch = arr[i];
            if (ch == 'L') {
                f = n;
            }
            else if(ch == 'R'){
                f = 0;
            } else {
                f = Math.max(f-1,0);
            }
            force[i] -= f;
        }
        StringBuilder sb = new StringBuilder();
        for(int el : force){
            if(el > 0){
                sb.append('R');
            }
            else if(el < 0){
                sb.append('L');
            }
            else{
                sb.append('.');
            }
        }
        return sb.toString();
    }
}