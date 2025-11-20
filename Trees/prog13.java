
class ValidBST {
    
    public boolean isValidBST(TreeNode root){

        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // min root max
    private boolean validate(TreeNode root, long min, long max){
        if(root == null) return true;

        // check : node must lie within the range
        if(root.data <= min || root.data >= max) return false;

        return validate(root.left, min, root.data) 
            && validate(root.right, root.data, max);
    }
}
