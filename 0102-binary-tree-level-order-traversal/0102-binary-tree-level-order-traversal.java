import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            List<Integer> ans = new ArrayList<>();

            int size = q.size();

            for(int i = 0; i < size; i++){

                TreeNode temp = q.peek();   // removed (val)
                q.remove();

                ans.add(temp.val);

                if(temp.left != null){
                    q.add(temp.left);
                }

                if(temp.right != null){
                    q.add(temp.right);
                }
            }

            res.add(ans);   // corrected
        }

        return res;
    }
}
