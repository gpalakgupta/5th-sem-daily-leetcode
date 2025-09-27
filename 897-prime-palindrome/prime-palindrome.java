class Solution {
    public int primePalindrome(int n) {
        int l = 1;
        if(n <= 2){
            return 2;
        }

        if(n <= 3){
            return 3;
        }
        if(n <= 5){
            return 5;
        }
        if(n <= 7){
            return 7;
        }
        if(n <= 11){
            return 11;
        }

        while(true){
            int half = (l+1)/2;
            int min = (int)(Math.pow(10,half-1));
            int max = (int)(Math.pow(10,half)-1);
            for(int num = min; num <= max; num++){
                String str;
                if(l % 2 == 0){
                    continue;
                }
                else{
                    str = String.valueOf(num)+rev(num).substring(1);
                }
                int val = Integer.parseInt(str);
                if(val >= n && isprime(val)){
                    return val;
                }
            }
            l++;
        }
    }
    public boolean isprime(int n){
        if(n < 2){
            return false;
        }
        if(n%2 == 0){
            return n == 2;
        }
        for(int i = 3; i*i <= n; i+=2){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public String rev(int num){
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        return sb.reverse().toString();
    }
}