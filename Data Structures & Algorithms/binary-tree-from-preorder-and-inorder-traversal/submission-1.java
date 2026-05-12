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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder = [400,9,1,2,20,15,17], inorder = [1,9,2,400,15,20,7]
        if( preorder.length == 0 || inorder.length == 0){
            return null;
        }
        // get root
        TreeNode rootofSubtree = new TreeNode(preorder[0]);
        int leftTreeLength = -1; 
        
        // find root idx in inorder arr
        for(int i = 0; i< inorder.length; i++){
            if(inorder[i] == preorder[0]) {
                leftTreeLength = i; // index 3 for 400 root
                break;
            }
        }
        // how many items which will be in the left sub tree
        
        /*left sub tree will contain [1,9,2]
        right sub tree will contain [15,20,7]
        preorder[1:leftTreeLength+1] = [9,1,2]*/

        // traverse left from legnth(idx) given in leftTreeLength
        // pre[1:leftTreeLength](last idx is NON-inclusive) in[0:leftTreeLength]
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftTreeLength + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftTreeLength);
        rootofSubtree.left = buildTree(leftPreorder, leftInorder);

        int[] rightPreorder = Arrays.copyOfRange(preorder, leftTreeLength + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, leftTreeLength +1, inorder.length);
        rootofSubtree.right = buildTree(rightPreorder, rightInorder);
        
        return rootofSubtree;

    }
}
