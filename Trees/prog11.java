// BST => { left < root < right }

class BST {
    // search
    public TreeNode search(TreeNode root, int key){
        if(root == null || root.data == key) return root;

        if(key < root.data){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
    }

    // insert
    public TreeNode insert(TreeNode root, int key){
        if(root == null) return new TreeNode(key);

        if(root.data < key){
            root.left = insert(root.left, key);
        }else if(root.data > key){
            root.right = insert(root.right, key);
        }

        return root; // if key already exists
    }

    // delete
    public TreeNode delete(TreeNode root, int key){
        if(root == null) return null;

        if(root.data < key){
            root.left = delete(root.left, key);
        }else if(root.data > key){
            root.right = delete(root.right, key);
        }else{

            // case 1: no children
            if(root.left == null && root.right == null) return null;

            // case 2: only one child
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            // case 3: two children
            TreeNode successor = findMin(root.right);
            root.data = successor.data;
            root.right = delete(root.right, successor.data);
        }
        return root;
    }

    // helper
    private TreeNode findMin(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}
