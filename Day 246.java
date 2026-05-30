class Solution {
    public void replaceElements(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];

        temp[0] = arr[0] ^ arr[1];

        for (int i = 1; i < n - 1; i++) {
            temp[i] = arr[i - 1] ^ arr[i + 1];
        }

        temp[n - 1] = arr[n - 2] ^ arr[n - 1];

        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
}
