class Solution {
    public String sortVowels(String s) {
       String str = "AEIOUaeiou";
        int cnt = 0;
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(str.contains(ch+"")){
                cnt++;
            }
        }
        char[] ch = new char[cnt];
        int j = 0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(str.contains(c+"")){
                ch[j++] = c;
            }
        }
        j = 0;
        Arrays.sort(ch);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(str.contains(c+"")){
                sb.append(ch[j++]);
                
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}