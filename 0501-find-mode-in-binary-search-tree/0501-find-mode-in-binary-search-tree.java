import java.util.*;

class Solution {

    HashMap<Integer, Integer> mp = new HashMap<>();

    void dfs(TreeNode root){
        if(root == null) return;

        dfs(root.left);
        mp.put(root.val, mp.getOrDefault(root.val, 0) + 1);
        dfs(root.right);
    }

    public int[] findMode(TreeNode root) {

        dfs(root);

        ArrayList<Integer> list = new ArrayList<>();
        int maxfreq = 0;

        for(Map.Entry<Integer, Integer> it : mp.entrySet()){
            if(it.getValue() > maxfreq){
                maxfreq = it.getValue();
                list = new ArrayList<>();
                list.add(it.getKey());
            }
            else if(it.getValue() == maxfreq){
                list.add(it.getKey());
            }
        }

        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
}