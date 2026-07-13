class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return null;

        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = head;
        list.add(temp.val);

        while (temp.next != null) {
            if (temp.val != temp.next.val) {
                list.add(temp.next.val);
            }
            temp = temp.next;
        }

        ListNode curr = head;
        int i = 0;

        while (i < list.size()) {
            curr.val = list.get(i++);
            if (i == list.size()) {
                curr.next = null;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}