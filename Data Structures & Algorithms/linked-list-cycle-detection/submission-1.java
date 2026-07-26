/*
Understand
    input: given a head of linked list
    output: boolean of if we find a cycle in that list or not
    
    list with cycle: [1,2]
    list w/o cycle: [1]

Match:
    approaches:
        -> storing visited nodes in a set,
        using slow/fast pointers,
        or changing the list somehow?
Plan
    create visited nodes set
    while cur != null:
        check current node,
        if already seen, return true,
        otherwise, add to set,
Implement ->
Review
    edge cases: 
        empty list: [] -> cur is null so it automatically returns false
        one node, no cycle: [2] -> just added to visited set then exits becasue cur is null. 
        one node, cycle to itself: [3] -> will see the visited node so it will return true and exit the loop!

Evaluate:
    set approach 
        time: O(n)
        space: O(n)
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
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode cur = head;
        while(cur != null){
            if(visited.contains(cur)){ // if node already visited, is a cycle!
                return true;
            }
            // else add to visited set and move to next node
            visited.add(cur);
            cur = cur.next;
        }
        return false;
    }
}
