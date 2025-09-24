class Solution {
    HashMap<String,Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        map.clear();
        return helper(s1,s2);
    }
    public boolean helper(String s1, String s2){
        if(s1.equals(s2)){
            return true;
        }

        if(s1.length() != s2.length()){
            return false;
        }
        String key = s1+"-"+s2;
        if(map.containsKey(key)){
            return map.get(key);
        }
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        if(!Arrays.equals(ch1,ch2)){
            map.put(key,false);
            return false;
        }
        boolean result = false;
        int n = s1.length();
        for(int i = 1; i<s1.length(); i++){

            boolean swap = helper(s1.substring(0,i),s2.substring(n-i)) && helper(s1.substring(i),s2.substring(0,n-i));

            boolean noswap = helper(s1.substring(0,i),s2.substring(0,i)) && helper(s1.substring(i),s2.substring(i));
            if(swap || noswap){
                result = true;
                break;
            }
        }
        map.put(key,result);
        return result;
    }
}