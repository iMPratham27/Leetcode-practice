package Trees;

class LCAOfBST {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;

        if(p.data < root.data && q.data < root.data){
            
            return lowestCommonAncestor(root.left, p, q);
        
        }else if(p.data > root.data && q.data > root.data){

            return lowestCommonAncestor(root.right, p, q);
        
        }else{

            return root; // split point
        }
    }
}
