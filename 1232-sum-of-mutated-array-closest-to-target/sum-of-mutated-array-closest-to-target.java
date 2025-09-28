class Solution {
    public int findBestValue(int[] arr, int target) {
        int n = arr.length;
        int st = 0; 
        int end = 0;
        for(int el : arr){
            end = Math.max(el,end);
        }

        int ans = -1;
        int diff = Integer.MAX_VALUE;
        while(st <= end){
            int mid = st+(end-st)/2;
            int val = get(arr,mid);
            int d = Math.abs(target-val);
            if(d < diff || (d == diff && mid < ans)){
                ans = mid;
                diff = d;
            }
            if(val < target){
                st = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
    public int get(int[] arr, int val){
        int sum = 0;
        for(int el : arr){
            sum += Math.min(el,val);
        }
        return sum;
    }
}