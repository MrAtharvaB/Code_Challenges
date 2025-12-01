class Solution {
    
    static class Node {
        Node[] child = new Node[2];
        int count;
    }
    
    private static final int MAX_BIT = 15;
    
    public int cntPairs(int[] arr, int k) {
        Node root = new Node();
        long ans = 0;
        
        for (int x : arr) {
            ans += countLessThanK(root, x, k);
            insert(root, x);
        }
        return (int) ans;
    }
    
    private void insert(Node root, int num) {
        Node node = root;
        node.count++;
        for (int bit = MAX_BIT; bit >= 0; bit--) {
            int b = (num >> bit) & 1;
            if (node.child[b] == null) {
                node.child[b] = new Node();
            }
            node = node.child[b];
            node.count++;
        }
    }
    
    private long countLessThanK(Node root, int num, int k) {
        Node node = root;
        long res = 0;
        
        for (int bit = MAX_BIT; bit >= 0; bit--) {
            if (node == null) break;
            
            int xb = (num >> bit) & 1;
            int kb = (k >> bit) & 1;
            
            if (kb == 0) {
                node = node.child[xb];
            } else {
                Node sameBitChild = node.child[xb];
                if (sameBitChild != null) {
                    res += sameBitChild.count;
                }
                node = node.child[xb ^ 1];
            }
        }
        return res;
    }
}
