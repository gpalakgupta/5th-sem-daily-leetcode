class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        int st = 1;
        int end = (int)(1e9);
        int ans = -1;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(isvalid(dist,hour,mid)){
                ans = mid;
                end = mid-1;
            }
            else{
                st = mid+1;
            }
        }
        
        return ans;
    }
    public boolean isvalid(int[] nums, double hour, int mid){
        double time = 0;
        int i = 0;
        while(i<nums.length-1){
            int minTime = (nums[i]+mid-1)/mid;
            time+=minTime;
            if(time > hour){
                return false;
            }
             i++;
        }
       time += (double) nums[i] / mid;
        
        return time <= hour;
    }
}