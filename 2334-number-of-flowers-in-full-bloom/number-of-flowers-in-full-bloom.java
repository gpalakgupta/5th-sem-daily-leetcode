class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = people.length;
        int n1 = flowers.length;
        int[] start = new int[n1];
        int[] ending = new int[n1];
        for(int i = 0; i<n1; i++){
            start[i] = flowers[i][0];
            ending[i] = flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(ending);
        int st = 0;
        int end = n;
        for(int el : people){
            end = Math.max(end,el);
        }

        int[] ans = new int[n];
        int i = 0;
        for(int el : people){
            int upper = upperBound(el,start);
            int lower = upperBound(el-1,ending);
            // System.out.println(upper);
            // System.out.println(lower);
            ans[i++] = upper-lower;
        }
        return ans;
    }
    public int upperBound(int el, int[] arr){
        int st = 0;
        int end = arr.length-1;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(arr[mid] <= el){ 
                st = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return st;
    }
    
}