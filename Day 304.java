class Solution {
    int preIndex;
    java.util.HashMap<Integer, Integer> map;

    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        preIndex = 0;
        map = new java.util.HashMap<>();

        for (int i = 0; i < preMirror.length; i++) {
            map.put(preMirror[i], i);
        }

        return build(pre, 0, preMirror.length - 1);
    }

    private Node build(int[] pre, int l, int r) {
        if (preIndex >= pre.length || l > r)
            return null;

        Node root = new Node(pre[preIndex++]);

        if (l == r || preIndex >= pre.length)
            return root;

        int idx = map.get(pre[preIndex]);

        root.left = build(pre, idx, r);
        root.right = build(pre, l + 1, idx - 1);

        return root;
    }
}
