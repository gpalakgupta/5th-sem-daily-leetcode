class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        helper(candidates, target, 0, ans, ll);
        return ans;
    }

    public void helper(int[] arr, int target, int idx, List<List<Integer>> ans, List<Integer> ll) {
        if (target == 0) {
            ans.add(new ArrayList<>(ll));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (target >= arr[i]) {
                ll.add(arr[i]);
                helper(arr, target - arr[i], i, ans, ll);
                ll.remove(ll.size() - 1);
            }
        }

    }
}