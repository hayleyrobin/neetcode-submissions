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
    // Reverse the rest of the list (after the current node), 
    // then attach the current node to the end of that reversed sublist.
    public ListNode reverseList(ListNode head) {
        // 0->1->2->3
         // Base case: empty list or last node
        if(head == null) return head; // // this node becomes the new head

        ListNode newNode = head;

        // Reverse the rest of the list (everything after 'head')
        if(head.next != null)
        {
            // Rewire: the node after 'head' should now point back to 'head'
            newNode = reverseList(head.next); // returns new head of reversed subNodes
            head.next.next = head; // make the next node(last node) point to this(prev) node!
        }
        // Clean up: current head becomes the tail (new end of list)
        head.next = null;

        // Return: the new head from the recursive call
        return newNode; // OG last node propogates up
        
    }
}
