class Solution {
    public int subsetXORSum(int[] nums) {
        List<Integer> lt = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        subset(nums,0,lt,ans);
        ans.remove(0);
        int sum = 0;
        for(int i = 0; i<ans.size(); i++){
            int t = 0;
            for(int j = 0; j<ans.get(i).size(); j++){
                t  = t^ans.get(i).get(j);
            }
            sum+=t;
        }
        return sum;
    }
    public void subset(int[] nums, int idx, List<Integer> lt, List<List<Integer>> ans){
        if(idx == nums.length){
            ans.add(new ArrayList<>(lt));
            return;
        }
        int el = nums[idx];
        subset(nums,idx+1,lt,ans);
        lt.add(el);
        subset(nums,idx+1, lt, ans);
        lt.remove(lt.size()-1);
    }
}