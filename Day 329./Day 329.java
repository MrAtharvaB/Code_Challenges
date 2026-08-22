class Solution {
    boolean findPath(Node root, int val, StringBuilder path) {
        if (root == null)
            return false;

        if (root.data == val)
            return true;

        path.append('L');
        if (findPath(root.left, val, path))
            return true;
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if (findPath(root.right, val, path))
            return true;
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    int countTurns(StringBuilder path) {
        int turns = 0;

        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) != path.charAt(i - 1))
                turns++;
        }

        return turns;
    }

    int numberOfTurns(Node root, int first, int second) {
        StringBuilder path1 = new StringBuilder();
        StringBuilder path2 = new StringBuilder();

        findPath(root, first, path1);
        findPath(root, second, path2);

        int i = 0;

        while (i < path1.length() &&
               i < path2.length() &&
               path1.charAt(i) == path2.charAt(i)) {
            i++;
        }

        StringBuilder path = new StringBuilder();

        for (int j = path1.length() - 1; j >= i; j--)
            path.append(path1.charAt(j));

        for (int j = i; j < path2.length(); j++)
            path.append(path2.charAt(j));

        int turns = countTurns(path);

        return turns == 0 ? -1 : turns;
    }
}
