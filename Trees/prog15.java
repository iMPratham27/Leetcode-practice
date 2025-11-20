import java.util.*;

class RightSideView {
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){

            int rightNode = 0;
            int qSize = q.size();

            for(int i=0; i<qSize; i++){
                TreeNode node = q.poll();
                rightNode = node.data;

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }

            result.add(rightNode);
        }
        return result;
    }
}
