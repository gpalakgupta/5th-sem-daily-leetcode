class Solution {
    HashMap<String, Integer> map = new HashMap<>();

    public int maxPartitionsAfterOperations(String s, int k) {
        return helper(s,k,0,0,true)+1;
    }

    public int helper(String s, int k, int idx, long uni_char, boolean canPart) {
        if (idx >= s.length()) {
            return 0;
        }
        String key = idx+"-"+uni_char+"-"+canPart;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int charIdx = s.charAt(idx) - 'a';
        long charUpdate = uni_char | (1L << charIdx);
        long uniCnt = Long.bitCount(charUpdate);

        int result = 0;
        if (uniCnt > k) {
            result = 1 + helper(s, k, idx + 1, 1L << charIdx, canPart);
        } else {
            result = helper(s, k, idx + 1, charUpdate, canPart);
        }
        if (canPart) {
            for (int i = 0; i < 26; i++) {
                long newcharUpdate = uni_char | (1L << i);
                long newuniCnt = Long.bitCount(newcharUpdate);
                if (newuniCnt > k) {
                    result = Math.max(result,1 + helper(s, k, idx + 1, 1L << i, false));
                } else {
                    result = Math.max(result,helper(s, k, idx + 1, newcharUpdate, false));
                }
            }
        }
        map.put(key,result);
        return result;
    }
}