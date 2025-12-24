class Solution {
    public int countCollisions(String directions) {
        int ans = 0;
        boolean s = false;
        int right = 0;
        for(char ch : directions.toCharArray()){
            if(ch == 'R'){
                right++;
            }
            else if(ch == 'S'){
                ans += right;
                right = 0;
                s = true;
            }
            else{
                if(right > 0){
                    ans += right + 1;
                    right  = 0;
                    s = true;
                }
                else if(s){
                    ans += 1;
                }
            }
        }
        return ans;
    }
}