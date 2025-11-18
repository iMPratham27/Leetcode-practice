package Trees;
import java.util.*;

class LeftSideView {
    
    public List<Integer> leftSideVidew(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int qSize = q.size();

            for(int i=0; i<qSize; i++){
                TreeNode node = q.poll();

                if(i==0) result.add(node.data);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }

        return result;
    }
}
