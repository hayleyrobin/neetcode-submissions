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
    //1->2->3->4->null
    public ListNode reverseList(ListNode curr) {
        if(curr == null){ 
            System.out.println("This is the edge case when the input is None");
            return null;} // base case : null node

        ListNode oldTail = curr; // 3
        if(curr.next != null){ // if not last node
            System.out.println("This is the base case. At this point, we are at the last node in the old tail," + curr.next.val);
            oldTail = reverseList(curr.next); // 1 2 3 4
            // a->b : a<-b 
            curr.next.next = curr; // 3->4->3 : 4->3->2->3 : 4->3->2->1->2
        }
        // if last node from reversed
        // make last node point to null
        curr.next = null; // 4->3->null : 4->3->2->null : 4->3->2->1->null

        return oldTail;
    }
}
