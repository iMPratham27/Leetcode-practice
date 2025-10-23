package Trees;

class BalancedBT {

    private int checkHeight(TreeNode root){
        if(root == null) return 0;

        int leftHt = checkHeight(root.left);
        if(leftHt == -1) return -1;

        int rightHt = checkHeight(root.right);
        if(rightHt == -1) return -1;

        if(Math.abs(leftHt-rightHt) > 1) return -1;

        return 1 + Math.max(leftHt, rightHt);
    }
    
    public boolean isBalanced(TreeNode root){
        if(checkHeight(root) != -1){
            return true;
        }else{
            return false;
        }
    }
}
