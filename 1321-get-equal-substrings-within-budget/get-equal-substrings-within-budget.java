class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Math.abs(s.charAt(i)-t.charAt(i));
        }
        // System.out.println(arr[0]);
        int st = 0;
        int end = 0;
        int ans = 0;
        int sum = 0;
        while(end < n){
            sum += arr[end];
            while(st <= end && sum > maxCost){
                sum-=arr[st];
                st++;
            }
            ans = Math.max(ans,end-st+1);
            end++;
        }
        return ans;
    }
}