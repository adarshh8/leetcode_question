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
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return list;
        }
        q.add(root);
      
        while(!q.isEmpty()){
            int size = q.size();
            double avg = 0;
            double sum = 0;
            for(int i=0;i<size;i++){
                TreeNode temp=q.peek();
                q.remove();
                sum = sum+temp.val;

                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            avg=sum/size;
            list.add(avg);
        }
        return list;
    }
}