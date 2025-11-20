/*
    The diameter of a tree is the longest path (in edges) between any two nodes in the tree.
    This path may or may not pass through the root.
*/

class Pair {
    int height;
    int diameter;
    Pair(int h, int d){
        height = h;
        diameter = d;
    }
}

class DiameterOfTree {

    Pair diameterHelper(TreeNode root){
        if(root == null) return new Pair(-1, 0);

        Pair left = diameterHelper(root.left);
        Pair right = diameterHelper(root.right);

        int height = 1 + Math.max(left.height, right.height);
        int pathThroughRoot = left.height + right.height + 2;

        int diameter = Math.max(pathThroughRoot, Math.max(left.diameter, right.diameter));

        return new Pair(height, diameter);
    }
    
    int diameter(TreeNode root){
        return diameterHelper(root).diameter;
    }
}
