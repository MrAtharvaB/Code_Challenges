class Solution {

    boolean isIdentical(Node a, Node b) {
        if (a == null && b == null) return true;

        if (a == null || b == null) return false;

        return (a.data == b.data) &&
               isIdentical(a.left, b.left) &&
               isIdentical(a.right, b.right);
    }

    public boolean isSubTree(Node root1, Node root2) {

        if (root2 == null) return true;

        if (root1 == null) return false;

        if (isIdentical(root1, root2))
            return true;

        return isSubTree(root1.left, root2) ||
               isSubTree(root1.right, root2);
    }
}
