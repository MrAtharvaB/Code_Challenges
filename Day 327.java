class Solution {
    int maxDiff(Node root) {
        int left = dfs(root.left, root.data);
        int right = dfs(root.right, root.data);
        return Math.max(left, right);
    }

    int dfs(Node root, int maxAncestor) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int diff = maxAncestor - root.data;
        maxAncestor = Math.max(maxAncestor, root.data);

        return Math.max(diff,
                Math.max(dfs(root.left, maxAncestor),
                         dfs(root.right, maxAncestor)));
    }
}
