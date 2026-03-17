import java.util.*;

class Solution {
    public int minTime(Node root, int target) {
        
        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = mapParents(root, parentMap, target);
        
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        
        queue.offer(targetNode);
        visited.add(targetNode);
        
        int time = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burned = false;
            
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                
                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.offer(curr.left);
                    visited.add(curr.left);
                    burned = true;
                }
                
                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.offer(curr.right);
                    visited.add(curr.right);
                    burned = true;
                }
                
                if (parentMap.containsKey(curr) && !visited.contains(parentMap.get(curr))) {
                    queue.offer(parentMap.get(curr));
                    visited.add(parentMap.get(curr));
                    burned = true;
                }
            }
            
            if (burned) time++;
        }
        
        return time;
    }
    
    private Node mapParents(Node root, Map<Node, Node> parentMap, int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        Node targetNode = null;
        
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            
            if (curr.data == target) {
                targetNode = curr;
            }
            
            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                queue.offer(curr.left);
            }
            
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
        
        return targetNode;
    }
}
