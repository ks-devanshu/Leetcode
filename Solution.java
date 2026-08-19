class Solution {
    int[] nums;
    int n;
    public int rob(int[] nums) {

        // dp-memoization -- optimized
        int oneBefore = nums[0];
        int twoBefore = 0;
        int i = 1;
        while (i < n) {
            int current = Math.max(oneBefore, twoBefore+nums[i]);
            twoBefore = oneBefore;
            oneBefore = current;
            i++;
        }

        return oneBefore;

        // this.nums = nums;
        // n = nums.length;

        // int money = 0;
        // for (int i = 0; i<n; i++)
        //     money = Math.max(money, rob(i, 0));

        // return money;
    }

    class Node {
        int sumAtPoint;
        int value;

        public Node(int sumAtPoint, int value) {
            this.sumAtPoint = sumAtPoint;
            this.value = value;
        }
    }

    private Map<Integer, Node> map = new HashMap<>();

    private int rob(int i, int robbed) {
        if (map.containsKey(i)) {
            Node node = map.get(i);
            return node.value - node.sumAtPoint + robbed;
        }
        if (i >= n)
            return robbed;

        int maxRobbed = Math.max(rob(i + 2, robbed+nums[i]) , rob(i+1, robbed));

        if (map.containsKey(i) && map.get(i).value < maxRobbed)
            map.get(i).value = maxRobbed;
        else
            map.put(i, new Node(robbed, maxRobbed));

        return maxRobbed;
    }
}