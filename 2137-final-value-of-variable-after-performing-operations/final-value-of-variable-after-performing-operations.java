class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for(String str : operations){
            if(str.equals("--X") || str.equals("X--")){
                ans-=1;
            }
            else{
                ans+=1;
            }
        }
        return ans;
    }
}