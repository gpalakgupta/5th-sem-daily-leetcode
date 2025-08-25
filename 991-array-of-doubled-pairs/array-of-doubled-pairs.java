import java.util.*;

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int n = arr.length;
        Integer[] nums = new Integer[n];
        int i = 0;
        for(int el : arr){
            nums[i++] = el;
        }
       Arrays.sort(nums, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));

        for (int num : nums) {
            if (count.get(num) == 0) continue;  

            int want = num * 2;
            if (count.getOrDefault(want, 0) == 0) {
                return false;  
            }
            count.put(num, count.get(num) - 1);
            count.put(want, count.get(want) - 1);
        }

        return true;
    }
}
