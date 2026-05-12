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
    public List<Integer> inorderTraversal(TreeNode root) {
       // make a list and explicit stack to mimic call stack
        List<Integer> sortList = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        TreeNode cur = root;
        
        // while current node is not null or stack is not empty
        while(cur != null || !stack1.isEmpty()){
            // while cur node isnt null, push onto stack & move to left
            while(cur != null){
                stack1.push(cur);
                cur = cur.left;
            }
            // if null
            cur = stack1.pop(); // go to previous (leafnode)
            sortList.add(cur.val); // add current node to list
            cur = cur.right; // go right
        }
        return sortList;
    }
}