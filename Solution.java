// class Solution {
//     private class Node {
//         private int value;
//         private int lcs;
//         private int rank;
//         private Node parent;

//         public Node(int value) {
//             this.value = value;
//             parent = this;
//             lcs = 1;
//             rank = 1;
//         }
//     }
//     private Map<Integer, Node> nodemap = new HashMap<>();

//     private Node findParent(int n) {
//         Node node = nodemap.get(n);
//         while (node.parent != node) {
//             node.parent = node.parent.parent;
//             node = node.parent;
//         }

//         return node;
//     }

//     private void union(int a, int b) {
//         Node first = findParent(a), second = findParent(b);

//         if (first == second) return;

//         if (first.rank > second.rank) {
//             second.parent = first;
//             first.lcs++;
//             first.rank++;
//         }
//         else {
//             first.parent = second;
//             second.lcs++;
//             second.rank++;
//         }
//     }

//     public int longestConsecutive(int[] nums) {
//         if (nums.length == 0 || nums.length == 1) return nums.length;
//         for (int num : nums) {
//             nodemap.putIfAbsent(num, new Node(num));
//         }

//         for (int num : nums) {
//             if (nodemap.containsKey(num-1))
//                 union(num, num-1);
//             if (nodemap.containsKey(num+1))
//                 union(num, num+1);
//         }

//         int max = 0;
//         Map<Integer, Integer> map = new HashMap<>();
//         Set<Integer> visited = new HashSet<>();

//         for (var num : nums) {
//             if (visited.contains(num)) continue;

//             int parent = findParent(num).value;
//             if (map.containsKey(parent))
//                 map.replace(parent, map.get(parent)+1);
//             else
//                 map.put(parent, 1);
//             max = Math.max(max, map.get(parent));
//             visited.add(num);
//         }

//         return max;
//     }
// }

// Optimal Solution without union find
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) return n;

        int maxLength = 0;

        Set<Integer> set = new HashSet<>();
        for (var num : nums)
            set.add(num);

        for (var num : set) {
            if (set.contains(num-1)) continue;

            int length = 0;
            while (set.contains(num+length)) {
                length++;
            }

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}