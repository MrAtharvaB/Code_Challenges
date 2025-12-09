class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            
            if(arr[index] < 0) {
                result.add(index + 1);
            } else {
                arr[index] = -arr[index];
            }
        }
        
        return result;
    }
}
