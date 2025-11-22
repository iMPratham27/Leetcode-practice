
class MaximumPathSum {

    private int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if(root == null) return 0;

        // avoid negatives
        int left = Math.max(maxGain(root.left), 0);
        int right = Math.max(maxGain(root.right), 0);

        int pathSum = root.data + left + right;

        maxSum = Math.max(maxSum, pathSum);

        // Return the best straight-line path going up from this node
        return root.data + Math.max(left, right);
    }
}
