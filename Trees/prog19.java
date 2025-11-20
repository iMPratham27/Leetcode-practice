import java.util.*;

class BTFromPostOrderAndInOrder {
    
    private int postIndex;
    Map<Integer, Integer> inOrderMap = new HashMap<>();

    public TreeNode buildTree(int inorder[], int postorder[]) {
        for(int i=0; i<inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }

        postIndex = postorder.length-1;

        return helper(postorder, 0, inorder.length-1);
    }

    private TreeNode helper(int postOrder[], int inStart, int inEnd){
        if(inStart > inEnd) return null;

        int rootVal = postOrder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inOrderMap.get(rootVal);

        // postOrder => (Left, Right, Data)
        root.right = helper(postOrder, rootIndex+1, inEnd);
        root.left = helper(postOrder, inStart, rootIndex-1);

        return root;
    }
}
