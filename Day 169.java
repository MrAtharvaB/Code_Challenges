class Solution {
    
    class Pair {
        Node node;
        int hd;
        
        Pair(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node node = p.node;
            int hd = p.hd;
            
            if(!map.containsKey(hd)){
                map.put(hd, node.data);
            }
            
            if(node.left != null){
                q.add(new Pair(node.left, hd - 1));
            }
            
            if(node.right != null){
                q.add(new Pair(node.right, hd + 1));
            }
        }
        
        for(int val : map.values()){
            result.add(val);
        }
        
        return result;
    }
}
