class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int count = 0;
    }

    public ArrayList<String> findPrefixes(String[] arr) {
        TrieNode root = new TrieNode();

        for (String word : arr) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (curr.child[idx] == null) {
                    curr.child[idx] = new TrieNode();
                }
                curr = curr.child[idx];
                curr.count++;
            }
        }

        ArrayList<String> ans = new ArrayList<>();

        for (String word : arr) {
            TrieNode curr = root;
            StringBuilder prefix = new StringBuilder();

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                curr = curr.child[idx];
                prefix.append(ch);

                if (curr.count == 1) {
                    break;
                }
            }

            ans.add(prefix.toString());
        }

        return ans;
    }
}
