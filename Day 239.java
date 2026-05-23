class Solution {
    public void toSumTree(Node root) {
        solve(root);
    }
    
    private int solve(Node node) {
        if (node == null)
            return 0;
        
        int leftSum = solve(node.left);
        int rightSum = solve(node.right);
        
        int original = node.data;
        node.data = leftSum + rightSum;
        
        return original + leftSum + rightSum;
    }
}
