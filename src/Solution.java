import java.util.Map;
import java.util.HashMap;

public class Solution {
    private int ways;
    private Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
//  Better Approach (Fibonacci)
//        if (n == 1) {
//            return 1;
//        }
//        int prev2 = 1;
//        int prev1 = 2;
//        for (int i = 3; i <= n; i++) {
//            int current = prev1 + prev2;
//            prev2 = prev1;
//            prev1 = current;
//        }
//        return prev1;

        return climb(n);
    }

    private int climb(int n) {
        if (map.containsKey(n))
            return map.get(n);

        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        map.put(n - 1, climb(n - 1));
        map.put(n - 2, climb(n - 2));

        return map.get(n - 1) + map.get(n - 2);
    }
}