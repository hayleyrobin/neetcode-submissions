/*
Understand
Preorder traversal is print cur node, then left and right
Input: root node, of a binary tree
Output: list, preorder traversal of its nodes
    Cases:
        one node -> [6] : [6]
        no nodes -> [null] : []
        root with only a left child -> [1,2] : [1,2]
Match
    Iterative with Stack
    Stack: holds just nodes
        Push right child before left child
            Why: if the stack is LIFO, the last thing pushed gets popped first. So pushing right then left makes left processed before right.

Plan
    create list once in the main method
    if root == null: return empty list immediately
    initialize stack
    push current node
    while stack isnt empty
        pop a node and add to list
        push children right then left
Review
    Test [1, null, 2, 3]
        current node : 1
        there is no left node so it returns and goes to right node 2. then it adds 2 to the list.
            3 the left node of 2 so it adds 3 to the list and then returns bc there are no more nodes.
        list after adding : [1,2,3]
        where recursion goes next
Evaluate
    Time: O(n) -> goes through all the nodes of tree
    Space: O(h) -> if tree is skewed, the iterative stack grows to about the number of nodes, so the space becomes O(n)

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
        if (root == null) return preorderList;

        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode curNode = stack1.pop();
            preorderList.add(curNode.val);
            // check if null before adding to stack
            if(curNode.right != null) stack1.push(curNode.right);
            if(curNode.left != null) stack1.push(curNode.left);
        }
        return preorderList;
    }
}