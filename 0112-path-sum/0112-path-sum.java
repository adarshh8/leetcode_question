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
    public boolean inorderTraversal(TreeNode root, int sum, int targetSum){
        if(root == null){
            return false;
        }
        sum = sum+root.val;
        if(root.left == null && root.right == null){
            if(sum == targetSum){
                return true;
            }else{
                return false;
            }
        }
        boolean leftside = inorderTraversal(root.left,sum,targetSum);
        boolean rightside = inorderTraversal(root.right,sum,targetSum);
        return leftside || rightside;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum =0;
        boolean result=inorderTraversal(root,sum,targetSum);
        return result;
    }
}