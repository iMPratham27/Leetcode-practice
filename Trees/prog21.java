class SumRootToLeaf {
    
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);    
    }

    private int helper(TreeNode root, int currentSum){
        if(root == null) return 0;

        currentSum = currentSum*10 + root.data;

        if(root.left == null && root.right == null) return currentSum;
        
        return helper(root.left, currentSum) + helper(root.right, currentSum);
    }
}
