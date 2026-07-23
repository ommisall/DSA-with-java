/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        
        List<Integer> nodes = new ArrayList<>();

        ListNode curr = head;
        while(curr != null) {
            nodes.add(curr.val);
            curr = curr.next;
        }

        int l = 0, r = nodes.size() - 1;
        while(l <= r) {
            if(nodes.get(l) != nodes.get(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}