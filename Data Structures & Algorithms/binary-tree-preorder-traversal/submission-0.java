/**
Understand
Preorder traversal is print cur node, then left and right
Input: root node, of a binary tree
Output: list, preorder traversal of its nodes
    Cases:
        one node -> [6] : [6]
        no nodes -> [null] : []
        root with only a left child -> [1,2] : [1,2]
Match
    Recursion or Iterative with Stack
Plan
    create list once in the main method, then pass it into a helper
        helper func inputs: current node, list
    root == null, return empty list?
        in helper func: return immediately?
    current node , print value
    go to left node using recursion
    go to right node using recursion
Review
    Test [1, null, 2, 3]
        current node : 1
            there is no left node so it returns and goes to right node 2. then it adds 2 to the list.
            3 the left node of 2 so it adds 3 to the list and then returns bc there are no more nodes.
        list after adding : [1,2,3]
        where recursion goes next
Evaluate
    Time: O(n) -> goes through all the nodes of tree
    Space: o(h) -> if tree is skewed, the recursion stack grows to about the number of nodes, so the space becomes O(n)
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderList = new ArrayList<>();
        preOrder(root, preorderList);
        return preorderList;
    }
    private void preOrder(TreeNode node, List<Integer> list){
        if(node == null) return;
        // print out or add to list
        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }
}