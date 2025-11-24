import java.util.*;

class SerializeAndDeserializeBT {

    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serializeHelper(sb, root);

        return sb.toString();
    }

    private void serializeHelper(StringBuilder sb, TreeNode root){
        if(root == null){
            sb.append("null,");
            return;
        }

        sb.append(root.data).append(",");
        serializeHelper(sb, root.left);
        serializeHelper(sb, root.right);
    }

    public TreeNode deserialize(String data){
        String dataArr[] = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(dataArr));

        return deserializeHelper(q);
    }

    private TreeNode deserializeHelper(Queue<String> q){
        String val = q.poll();
        if(val.equals("null")){
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(q);
        node.right = deserializeHelper(q);

        return node;
    }
}