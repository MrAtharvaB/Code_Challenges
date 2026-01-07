class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0 || k == 0) return result;

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < k; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        result.add(freq.size());

        for (int i = k; i < arr.length; i++) {
            int outgoing = arr[i - k];
            freq.put(outgoing, freq.get(outgoing) - 1);
            if (freq.get(outgoing) == 0) {
                freq.remove(outgoing);
            }

            int incoming = arr[i];
            freq.put(incoming, freq.getOrDefault(incoming, 0) + 1);

            result.add(freq.size());
        }

        return result;
    }
}
