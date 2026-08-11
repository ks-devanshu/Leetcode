class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) return null;
        if (k == 1) return lists[0];

        for (int i = 1; i < k; i++) {
            lists[i] = mergeTwo(lists[i - 1], lists[i]);
        }
        return lists[k - 1];
    }

    private ListNode mergeTwo(ListNode first, ListNode second) {
        if (first == null) return second;
        if (second == null) return first;

        var primary = first.val <= second.val ? first : second;
        var secondary = primary == first ? second : first;
        ListNode previous = null;
        var head = primary;

        while (primary != null && secondary != null) {
            if (primary.val <= secondary.val) {
                previous = primary;
                primary = primary.next;
            } else {
                if (previous == null) {
                    previous = new ListNode(secondary.val, primary);
                    head = previous;
                } else {
                    previous.next = new ListNode(secondary.val, primary);
                    previous = previous.next;
                }
                secondary = secondary.next;
            }
        }
        if (secondary != null) {
            previous.next = secondary;
        }

        return head;
    }
}