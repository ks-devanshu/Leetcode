class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int n = nums.length;
        int i = 0, sum = 0;
        int count = 0;
        while (i < n) {
            sum += nums[i];
            int look = sum - k;
            if (map.containsKey(look))
                count += map.get(look);

            if (map.containsKey(sum))
                map.replace(sum, map.get(sum)+1);
            else
                map.put(sum, 1);
            i++;
        }
        return count;
    }
}