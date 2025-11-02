package Trees;

// inOrder arrange the nodes in sorted order

class KthSmallestInBST {
    
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        
        inOrder(root, k);
        return result;
    }

    private void inOrder(TreeNode root, int k){

        if(root == null) return;

        inOrder(root.left, k);

        count++;
        if(count == k){
            result = root.data;
            return;
        }

        inOrder(root.right, k);
    }
}
