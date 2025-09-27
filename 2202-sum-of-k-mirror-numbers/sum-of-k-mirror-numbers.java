class Solution {
    public long kMirror(int k, int n) {
        long sum = 0L;
        int l = 1;
        while(n > 0){
            int half = (l+1)/2;
            long min = (long)(Math.pow(10,half-1));
            long max = (long)(Math.pow(10,half)-1);
            for(long num = min; num <= max; num++){
                String str;
                if(l % 2 == 0){
                    str = String. valueOf(num)+rev(num);
                }
                else{
                    str = String.valueOf(num)+rev(num).substring(1);
                }
                long val = Long.parseLong(str);
                String bk = baseK(val,k);
                if(ispal(bk)){
                    sum+=val;
                    n--;
                }
                if(n == 0){
                    return sum;
                }
            }
            l++;
        }
        return -1;
    }
        public String baseK(long n, int k){
            StringBuilder sb = new StringBuilder();
            while(n > 0){
                sb.append(n%k);
                n/=k;
            }
            return sb.reverse().toString();
        }

        public boolean ispal(String str){
            int i = 0;
            int j = str.length()-1;
            while(i<=j){
                if(str.charAt(i) != str.charAt(j)){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
        public String rev(long num){
            StringBuilder sb = new StringBuilder(String.valueOf(num));
            return sb.reverse().toString();
        }
    
}