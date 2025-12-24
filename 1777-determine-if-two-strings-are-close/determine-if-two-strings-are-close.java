class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        if(n != word2.length()){
            return false;
        }
        if(word1.equals(word2)){
            return true;
        }
        HashMap<Character,Integer> mp1 = new HashMap<>();
        HashMap<Character,Integer> mp2 = new HashMap<>();

        // HashSet<Integer> st1 = new HashSet<>();

        for(int i = 0; i<n; i++){
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
            mp1.put(ch1,mp1.getOrDefault(ch1,0)+1);
            mp2.put(ch2,mp2.getOrDefault(ch2,0)+1);
        }

        if(mp1.size() != mp2.size()){
            return false;
        }
        for(char key : mp1.keySet()){
            if(!mp2.containsKey(key)){
                return false;
            }
        }

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        for(char ch : mp1.keySet()){
            l1.add(mp1.get(ch));
        }

        for(char ch : mp2.keySet()){
            l2.add(mp2.get(ch));
        }

        Collections.sort(l1);
        Collections.sort(l2);

        return l1.equals(l2);

    }
}