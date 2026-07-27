/**
Understand
    Merge the sorted lists into one
    input: 2 heads of sorted linked lists
    output: head of the merged linked list

    if 1 list is empty -> return head of other list

Match
    2 ptrs, one on each list
    dummy head to build the result
Plan
    start at head list1 and list2. 
    while both are not null, 
        find smaller number and merge and progress this loop
    check the current to see which list isnt finished and add the rest into the merged list
Review
    edge cases:
        both empty
        one empty
        leftover nodes
Evaluate
    Time: O(m + n) because you traverse each list once
    Space: O(1) extra space because you only use a few pointers
 */
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
                ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            }
            else{
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
        }

        if (list1 != null){
            current.next = list1;
        }
        else{
            current.next = list2;
        }
        return dummy.next;
    }
}