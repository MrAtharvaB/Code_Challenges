class Solution {
    public int visibleBuildings(int arr[]) {
        int count = 0;
        int maxHeight = 0;
        
        for(int height : arr) {
            if(height >= maxHeight) {
                count++;
                maxHeight = height;
            }
        }
        
        return count;
    }
}
