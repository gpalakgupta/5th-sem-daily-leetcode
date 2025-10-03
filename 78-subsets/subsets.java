class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
          helper(nums,0,ans,ll);
          return ans;
    }
    public void helper(int[] nums , int idx, List<List<Integer>> ans, List<Integer> ll){
        if(idx >= nums.length){
            ans.add(new ArrayList<>(ll));
            return;
        }
        helper(nums,idx+1,ans,ll);
        ll.add(nums[idx]);
        helper(nums,idx+1,ans,ll);
        ll.remove(ll.size()-1);
    }
}