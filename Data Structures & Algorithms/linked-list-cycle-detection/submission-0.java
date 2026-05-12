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
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //  the fast pointer will eventually "lap" the slow pointer
        while(fast != null && fast.next != null){
            fast = fast.next.next; // moves 2 steps at a time
            slow = slow.next; // moves 1 step at a time
   
            if(fast == slow) return true; // a cycle exists
        }
        return false;
        
    }
}
