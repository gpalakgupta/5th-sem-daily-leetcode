class Solution {
    int n;

    public int maxProduct(String s) {
        n = s.length();
        
        return helper(0, s, "", "" );
    }

    public boolean isPal(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int helper(int idx, String str, String s1, String s2) {
        if (idx >= n) {
             
                if (isPal(s1) && isPal(s2)) {
                    return s1.length() * s2.length();
                }
            
            return 0;
        }

       
        int first = helper(idx + 1, str, s1 + str.charAt(idx), s2 );
        int second = helper(idx + 1, str, s1, s2 + str.charAt(idx) );
        int notake = helper(idx + 1, str, s1, s2 );
        return   Math.max(first, Math.max(second, notake));
    }
}