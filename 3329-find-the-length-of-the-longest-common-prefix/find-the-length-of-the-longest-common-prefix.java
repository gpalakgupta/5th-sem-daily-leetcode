class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> st = new HashSet<>();
        for(int el : arr1){
            while(!st.contains(el) && el > 0){
                st.add(el);
                el/=10;
            }
        }

        int ans = 0;
        for(int el : arr2){
            while(!st.contains(el) &&  el > 0){
                el/=10;
            }
            if(el  > 0){
                ans = Math.max(ans,(int)(Math.log10(el))+1);
            }
        }
        return ans;
    }
}