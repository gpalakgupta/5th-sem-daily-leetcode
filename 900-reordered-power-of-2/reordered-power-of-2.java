class Solution {
    public String sort(int n){
       String str = n+"";
       char[] ch = str.toCharArray();
       Arrays.sort(ch);
       return new String(ch);
    }
    public boolean reorderedPowerOf2(int n) {
        String str = sort(n);
        for(int i = 0; i<31; i++){
            if(str.equals(sort(1<<i))){
                return true;
            }
        }
        return false;
    }
}