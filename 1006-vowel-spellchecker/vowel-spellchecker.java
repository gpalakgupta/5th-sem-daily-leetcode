class Solution {
    HashSet<String> exact;
    HashMap<String,String> sensitive;
    HashMap<String,String> vowel;
    public String[] spellchecker(String[] wordlist, String[] queries) {
        int n = queries.length;
        String[] ans = new String[n];
        exact = new HashSet<>();
        sensitive = new HashMap<>();
        vowel = new HashMap<>();
        exact.clear();
        sensitive.clear();
        vowel.clear();
        for(String el : wordlist){
            exact.add(el);

            String lower = el.toLowerCase();
            if(!sensitive.containsKey(lower)){
                sensitive.put(lower,el);
            }

            String vowelcheck = helper(lower);
            if(!vowel.containsKey(vowelcheck)){
                vowel.put(vowelcheck,el);
            }
        }
        int i = 0;
        for(String el : queries){
            String str = match(el);
            ans[i++] = str;
        }
        return ans;
    }
    public String helper(String str){
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                sb.append('*');
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public String match(String str){
        if(exact.contains(str)){
            return str;
        }

        String lower = str.toLowerCase();
        if(sensitive.containsKey(lower)){
            return sensitive.get(lower);
        }

        String vowelcheck = helper(lower);
        if(vowel.containsKey(vowelcheck)){
            return vowel.get(vowelcheck);
        }
        return "";
    }
}