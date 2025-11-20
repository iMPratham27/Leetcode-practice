
class GoodNodes {

    private int count = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    private void dfs(TreeNode root, int maxVal){
        if(root == null) return;

        if(root.data >= maxVal){
            count++;
            maxVal = root.data;
        }

        dfs(root.left, maxVal);
        dfs(root.right, maxVal);
    }
}
