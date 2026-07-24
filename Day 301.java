
class Solution {
    int ans = 1;

    public int longestConsecutive(Node root) {
        if (root == null)
            return -1;

        dfs(root, root.data - 1, 0);

        return ans == 1 ? -1 : ans;
    }

    void dfs(Node node, int parent, int len) {
        if (node == null)
            return;

        if (node.data == parent + 1)
            len++;
        else
            len = 1;

        ans = Math.max(ans, len);

        dfs(node.left, node.data, len);
        dfs(node.right, node.data, len);
    }
}
