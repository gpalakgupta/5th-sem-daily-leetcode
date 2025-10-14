class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        int ans = 0;
        int st = 1;
        int end = 0;
        for(int el : quantities){
            end = Math.max(end,el);
        }

        while(st <= end){
            int mid = st+(end-st)/2;
            if(isvalid(n,quantities,mid)){
                ans = mid;
                end = mid-1;
            }
            else{
                st = mid+1;
            }
        }
        return ans;
    }
    public boolean isvalid(int n, int[] arr, int mid){
        int c = 0;
        int total = 0;
        int i = 0;
        while(i < arr.length){
            if(arr[i] % mid == 0){
                total += arr[i]/mid;
            }
            else{
                total += arr[i]/mid;
                total++;
            }
            i++;
            if(total > n){
                return false;
            }
        }
        return true;
    }
}