import java.util.HashMap;

class Solution {
    public long subarrayXor(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int xor = 0;
        long count = 0;
        
        map.put(0, 1);
        
        for (int num : arr) {
            xor ^= num;
            
            if (map.containsKey(xor ^ k)) {
                count += map.get(xor ^ k);
            }
            
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        
        return count;
    }
}
