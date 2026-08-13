import java.util.List;
import java.util.ArrayList;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] candidates;
    int target;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        
        combinationSumHelper(new ArrayList<>(), 0, 0);
        return result;
    }
    
    private void combinationSumHelper(List<Integer> list, int currentSum, int i) {
        if (i >= candidates.length) return;
        if (currentSum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        if (currentSum > target) return;
        
        list.add(candidates[i]);
        combinationSumHelper(list, currentSum + candidates[i], i);

        list.remove(list.size() - 1);
        combinationSumHelper(list, currentSum, i+1);
    }
}