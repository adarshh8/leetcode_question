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
    public List<Integer> rightSideView(TreeNode root) {
         ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null){
            return list;
        }
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            list.add(q.peek().val);
            
            while(size-- > 0){
                TreeNode temp = q.poll();
                
                if(temp.right != null){
                    q.add(temp.right);
                }
                if(temp.left != null){
                    q.add(temp.left);
                }
            }
        }
        
        return list;
    }
}