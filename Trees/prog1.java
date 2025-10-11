package Trees;
import java.util.*;

class BinaryTree {
    Scanner sc = new Scanner(System.in);

    TreeNode constructBT(){
        System.out.print("Enter data: ");
        int data = sc.nextInt();

        TreeNode newNode = new TreeNode(data);

        System.out.print("Do you want to enter data on left of "+newNode.data +" : ");
        char leftNode = sc.next().charAt(0);
        if(leftNode == 'Y' || leftNode == 'y'){
            newNode.left = constructBT();
        }

        System.out.print("Do you want to enter data on right of "+newNode.data+" : ");
        char rightNode = sc.next().charAt(0);
        if(rightNode == 'y' || rightNode == 'Y'){
            newNode.right = constructBT();
        }
        return newNode;
    }

    void preOrder(TreeNode root){
        if(root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void inOrder(TreeNode root){
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    void postOrder(TreeNode root){
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }


    /*
     Because the stack is LIFO (Last-In-First-Out):
        If we push left first, it will be popped after the right → Wrong order.
        By pushing right first, left stays on top → gets processed first.
    */
    void preOrderIterative(TreeNode root){
        if(root == null) return;

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while(!s.isEmpty()){
            TreeNode node = s.pop();
            System.out.print(node.data + " ");

            if(node.right != null) s.push(node.right);

            if(node.left != null) s.push(node.left);
        }
    }

    /*
        The inner while(curr != null) goes all the way left.
        When it can’t go left, it processes (pop + print) the node.
        Then moves right and repeats. 
    */
    void inOrderIterative(TreeNode root){
        if(root == null) return;

        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !s.isEmpty()){

            // reach leftmost node
            while(curr!=null){
                s.push(curr);
                curr = curr.left;
            }

            curr = s.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    /*
        We use prev to remember the last visited node.
        If the right child exists and hasn’t been visited → go right.
        Otherwise → process the current node.
    */
    void postOrderIterative(TreeNode root){
        if(root == null) return;

        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;

        while(curr != null || !s.isEmpty()){

            while(curr!=null){
                s.push(curr);
                curr = curr.left;
            }

            curr = s.peek();
            if(curr.right != null && curr.right != prev){
                curr = curr.right;
            }else{
                System.out.print(curr.data + " ");
                s.pop();
                prev = curr;
                curr = null; // again we not traverse left
            }
        }
    }

    public static void main(String[] args) {
        
        BinaryTree bt = new BinaryTree();

        TreeNode root = null;
        root = bt.constructBT();

        System.out.println("---------------------");
        System.out.print("Preorder: ");
        bt.preOrder(root);
        System.out.println();
        System.out.print("Preorder Iterative: ");
        bt.preOrderIterative(root);
        System.out.println();

        System.out.println("---------------------");
        System.out.print("Inorder: ");
        bt.inOrder(root);
        System.out.println();
        System.out.print("Inorder Iterative: ");
        bt.inOrderIterative(root);
        System.out.println();

        System.out.println("---------------------");
        System.out.print("Postorder: ");
        bt.postOrder(root);
        System.out.println();
        System.out.print("Postorder Iterative: ");
        bt.postOrderIterative(root);
    }
}
