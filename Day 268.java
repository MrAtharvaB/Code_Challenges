class Solution {
    public String chooseSwap(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        int[] first = new int[26];
        Arrays.fill(first, -1);

        for (int i = 0; i < n; i++) {
            if (first[arr[i] - 'a'] == -1) {
                first[arr[i] - 'a'] = i;
            }
        }

        char c1 = 0, c2 = 0;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            int cur = arr[i] - 'a';

            for (int j = 0; j < cur; j++) {
                if (first[j] > i) {
                    c1 = arr[i];
                    c2 = (char) ('a' + j);
                    found = true;
                    break;
                }
            }

            if (found) break;
        }

        if (found) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == c1)
                    arr[i] = c2;
                else if (arr[i] == c2)
                    arr[i] = c1;
            }
        }

        return new String(arr);
    }
}
