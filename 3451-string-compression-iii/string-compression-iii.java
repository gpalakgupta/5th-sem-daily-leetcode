class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        char ch = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == ch) {
                cnt++;
            } else {
                while (cnt > 9) {
                    sb.append(9);
                    sb.append(ch);
                    cnt -= 9;
                }
                sb.append(cnt);
                sb.append(ch);
                cnt = 1;
                ch = c;
            }
        }
        while (cnt > 9) {
            sb.append(9);
            sb.append(ch);
            cnt -= 9;
        }
        sb.append(cnt);
        sb.append(ch);
        return sb.toString();
    }
}