package Trees;

// depth is of a node and maxDepth is of whole tree

class DepthOfTree {
    int depth(TreeNode root, int target){
        if(root == null) return -1;

        if(root.data == target) return 0; // root depth = 0

        int left = depth(root.left, target);
        if(left != -1) return left+1;

        int right = depth(root.right, target);
        if(right != -1) return right+1;

        return -1;
    }

    int maxDepth(TreeNode root){
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }
}
