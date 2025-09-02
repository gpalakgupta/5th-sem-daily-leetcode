class Solution {
    public boolean isvalid(String a, String b){
        String c = a+b;
        String d = b+a;
        return c.compareTo(d)<0;
    }
    public void sort(String[] str){
        for(int i = 1; i<str.length; i++){
            for(int j = 0; j<str.length-i; j++){
                if(isvalid(str[j],str[j+1])){
                    String t = str[j];
                    str[j] = str[j+1];
                    str[j+1] = t;
                }
            }
        }
    }
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] str = new String[n];
        for(int i = 0; i<n; i++){
            str[i] = nums[i]+"";
        }
        sort(str); //[2,10]
        int c = 0;
        String ans = "";
        for(String el : str){
            ans+=el;
            if(el.equals("0")){
                c++;
            }
        }
        // [0,0] 2
        // ans = 00
        // int 01 = 1
        if(c == n){
            long t = Long.parseLong(ans);
            return t+"";
        }
        return ans;
    }
}