class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        Node pre = null, suc = null;
        Node curr = root;
        
        while (curr != null) {
            if (curr.data < key) {
                pre = curr;
                curr = curr.right;
            } else if (curr.data > key) {
                suc = curr;
                curr = curr.left;
            } else {
                if (curr.left != null) {
                    Node temp = curr.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    pre = temp;
                }
                
                if (curr.right != null) {
                    Node temp = curr.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    suc = temp;
                }
                
                break;
            }
        }
        
        ArrayList<Node> res = new ArrayList<>();
        res.add(pre);
        res.add(suc);
        
        return res;
    }
}
