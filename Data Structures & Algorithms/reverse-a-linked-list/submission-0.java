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
    public ListNode reverseList(ListNode head) {
        //0->1->2->3
        ListNode curr = head; // 0
        ListNode prev = null; // null
        while(curr != null){
            ListNode temp = curr.next; // 1 // 2 // 3 // null
            curr.next = prev; // null<-0 // null<-0<-1 // null<-0<-1<-2<-3
            prev = curr; // 0 // 1 // 2 // 3
            curr = temp; // 1 // 2 // 3 // null
        }
        return prev;
    }
}
