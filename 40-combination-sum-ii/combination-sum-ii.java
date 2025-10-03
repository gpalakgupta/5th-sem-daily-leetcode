class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans =  new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,target,ans,ll,0);
        return ans;
    }
    public void helper(int[] candidates, int target, List<List<Integer>> ans, List<Integer> ll, int idx){
        if(target == 0){
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int i = idx; i<candidates.length;  i++){
            if(i > idx && candidates[i] == candidates[i-1]){
                continue;
            }
            if(target-candidates[i] >= 0){
                ll.add(candidates[i]);
                helper(candidates,target-candidates[i],ans,ll,i+1);
                ll.remove(ll.size()-1);
            }
        }
    }
}