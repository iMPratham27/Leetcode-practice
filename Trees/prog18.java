import java.util.*;

class BTFromPreOrderAndInOrder {

    private int preIndex = 0;
    Map<Integer, Integer> inOrderMap = new HashMap<>();

    public TreeNode buildTree(int preorder[], int inorder[]) {
        for(int i=0; i<inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length-1);
    }

    private TreeNode helper(int preOrder[], int inStart, int inEnd){
        if(inStart > inEnd) return null;

        // pick current root from preOrder
        int rootVal = preOrder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // find root in inOrder
        int rootIndex = inOrderMap.get(rootVal);

        root.left = helper(preOrder, inStart, rootIndex-1);
        root.right = helper(preOrder, rootIndex+1, inEnd);

        return root;
    }
}