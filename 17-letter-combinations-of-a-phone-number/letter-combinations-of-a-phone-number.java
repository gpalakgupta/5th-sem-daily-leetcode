class Solution {
    static String key[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> lt = new ArrayList<>();
        if(digits.length() == 0){
            return lt;
        }
        print(digits,"",lt);
        return lt;
    }
    public void print(String digits, String ans, List<String> lt){
        if(digits.length() == 0){
            lt.add(ans);
            return;
        }
        char ch = digits.charAt(0);
        String str = key[ch-'0'];
        for(int i = 0; i<str.length(); i++){
            print(digits.substring(1),ans+str.charAt(i),lt);
        }
    }
}