class Solution {
    public static boolean isValid( String  i , String j){
         String c =  i+j;
         String d = j+i;
         return c.compareTo(d)>0;
    }
    public static void sort(String[] str){
        for(int i = 0 ; i < str.length-1 ; i++){
            for(int j = 0 ; j < str.length-i-1 ; j++)
            if(!isValid(str[j] , str[j+1])){
                String temp = str[j];
                str[j] = str[j+1];
                str[j+1] = temp;
            }
        }
    }
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            str[i] = nums[i]+"";

        }
        sort(str);

    String ans = "";
    int c = 0;
    for(int i = 0 ; i  < str.length ; i++){
        ans+=str[i];
        if(str[i].equals( "0")){
            c++;
        }


        
    }
    if(c == nums.length){
         long t = Long.parseLong(ans);
            return t + "";
    }
return ans ;
    }
}