
//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        boolean startsWithList1 = true;
        if (list2.val < list1.val)
            startsWithList1 = false;

        var primary = startsWithList1 ? list1 : list2;
        var secondary = startsWithList1 ? list2 : list1;
        var head = primary;
        ListNode previous = null;

        while (primary != null && secondary != null) {
            if (primary.val < secondary.val) {
                previous = primary;
                primary = primary.next;
            }
            else {
                var newNode = new ListNode(secondary.val, primary);
                if (previous == null) {
                    previous = newNode;
                    head = previous;
                }
                else {
                    previous.next = newNode;
                    previous = previous.next;
                }

                secondary = secondary.next;
            }
        }
        if (secondary != null)
            previous.next = secondary;
        return head;
    }
}