
class SubTreeOfAnotherTree {

    private boolean isSametree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;

        if(root == null || subRoot == null) return false;

        if(root.data != subRoot.data) return false;

        return isSametree(root.left, subRoot.left) && isSametree(root.right, subRoot.right);
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot){
        if(root == null) return false;

        if(isSametree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
