class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character> st = new HashSet<>();
        for(char ch : brokenLetters.toCharArray()){
            st.add(ch);
        }
        String[] str = text.split(" ");
        int cnt = 0;
        for(int i = 0; i<str.length; i++){
            cnt++;
            for(int j = 0; j<str[i].length(); j++){
                if(st.contains(str[i].charAt(j))){
                    cnt--;
                    break;
                }
            }
        }
        return cnt;
    }
}