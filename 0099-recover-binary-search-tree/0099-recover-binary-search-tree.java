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
    void sortInorder(TreeNode root, ArrayList<Integer> list){
        if(root == null) return;

        sortInorder(root.left,list);
        list.add(root.val);
        sortInorder(root.right,list);
    }
    void ArrayST(TreeNode root, ArrayList<Integer> list){
        if(root == null) return;
        ArrayST(root.left,list);
        root.val = list.remove(0);
        ArrayST(root.right,list);
    }
    public void recoverTree(TreeNode root) {
          ArrayList<Integer> list = new ArrayList<>();
          sortInorder(root,list);
          Collections.sort(list);
          ArrayST(root,list);
        //   return root;

    }
}