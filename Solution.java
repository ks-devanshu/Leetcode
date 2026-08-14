import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        
        for (int i = 0; i<nums.length; i++) {
            int newTarget = target-nums[i];
            if (map.containsKey(newTarget)) {
                result[0] = i;
                result[1] = map.get(newTarget);
                break;
            }
            else
                map.put(nums[i], i);
        }
        
        return result;
    }
}