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
        // if lists are empty
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // preorder has first element
        TreeNode root = new TreeNode(preorder[0]);  // 1
        // find preorder first elmt in inorder array
        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i; // this will be the middle  | index 1
                break;
            }
        }

        // recursively build left subtree
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid + 1); // subarray of left preorder [2]
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid); // subarray of left inorder [2]
        root.left = buildTree(leftPreorder, leftInorder);

        // recursively build right subrree
        int[] rightPreorder = Arrays.copyOfRange(preorder, mid + 1, preorder.length); // subarr of right [3,4]
        int[] rightInorder = Arrays.copyOfRange(inorder, mid + 1, inorder.length); //[3,4]
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    

    }
}
