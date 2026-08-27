class Solution {
    public int pairSum(ListNode head) {
        ListNode node = head;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, n = 0;
        while (node != null) {
            map.put(n, node.val);
            n++;
            node = node.next;
        }
        int maxSum = 0;
        while (i < n/2) {
            maxSum = Math.max(maxSum, map.get(i) + map.get(n-i-1));
            i++;
        }

        return maxSum;
    }
}