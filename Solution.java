public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;

        ListNode slow = head, slow2 = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        if (fast == null || fast.next == null) return null;

        while (slow2 != slow) {
            slow = slow.next;
            slow2 = slow2.next;
        }

        return slow2;
    }
}