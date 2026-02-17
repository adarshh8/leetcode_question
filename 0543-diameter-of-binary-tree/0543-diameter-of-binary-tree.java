class Solution {

    int height(TreeNode root){
        if(root == null) return 0;

        int leftST = height(root.left);
        int rightST = height(root.right);

        return 1 + Math.max(leftST, rightST);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int leftheight = height(root.left);
        int rightheight = height(root.right);

        int diameterviaroot = leftheight + rightheight;

        int diameterleft = diameterOfBinaryTree(root.left);
        int diameterright = diameterOfBinaryTree(root.right);

        return Math.max(diameterviaroot, 
                        Math.max(diameterleft, diameterright));
    }
}
