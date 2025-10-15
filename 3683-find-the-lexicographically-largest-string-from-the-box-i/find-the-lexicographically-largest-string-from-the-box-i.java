class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length();
        int len = n - (numFriends - 1);
        String ans = "";
        for (int i = 0; i < n; i++) {
            int min = Math.min(len,n-i);
             String res = word.substring(i,i+min);
             if(res.compareTo(ans) > 0){
                ans = res;
             }
        }
        return ans;
    }
}