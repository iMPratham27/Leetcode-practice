package Trees;

// Longest path (in edges) from a node down to a leaf.

class HeightOfTree {
    
    int height(TreeNode root){
        if(root == null) return 0;

        int leftHt = height(root.left);
        int rightHt = height(root.right);

        return 1 + Math.max(leftHt, rightHt);
    }
}
