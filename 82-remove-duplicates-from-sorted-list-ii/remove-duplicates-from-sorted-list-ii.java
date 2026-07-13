class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        ListNode curr = head;

        while (curr != null) {

            int value = curr.val;
            int count = 0;

            while (curr != null && curr.val == value) {
                count++;
                curr = curr.next;
            }

            if (count == 1) {
                tail.next = new ListNode(value);
                tail = tail.next;
            }
        }

        return dummy.next;
    }
}