import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (var num : nums)
            if (set.contains(num))
                return true;
            else set.add(num);
        
        return false;
    }
}