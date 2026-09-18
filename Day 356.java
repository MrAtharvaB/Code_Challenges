class Solution {
    int prev = -1;
    int minDiff = Integer.MAX_VALUE;

    public int absDiff(Node root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(Node root) {
        if (root == null)
            return;

        // Left
        inorder(root.left);

        // Current node
        if (prev != -1) {
            minDiff = Math.min(minDiff, root.data - prev);
        }

        prev = root.data;

        // Right
        inorder(root.right);
    }
}
