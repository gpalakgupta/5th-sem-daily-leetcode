class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int st = 0;
        int end = n-1;
        Arrays.sort(people);
        int ans = 0;
        while(st <= end){
            if(people[st]+people[end] <= limit){
                st++;
                end--;
            }
            else{
                end--;
            }
            ans++;
        }
        return ans;
    }
}