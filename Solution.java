import java.util.List;
import java.util.ArrayList;

class Solution {
    private int[] nums;
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        subsetsHelper(new ArrayList<>(), 0);
        return result;
    }
    
    private void subsetsHelper(List<Integer> set, int i) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(set));
            return;
        }
        
        // include
        set.add(nums[i]);
        subsetsHelper(set, i+1);
        // exclude
        set.remove(set.size()-1);
        subsetsHelper(set, i+1);
    }
}