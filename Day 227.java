class Solution {

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    public boolean palindromePair(String[] arr) {

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {

            String word = arr[i];
            int len = word.length();

            for (int j = 0; j <= len; j++) {

                String left = word.substring(0, j);
                String right = word.substring(j);

                if (isPalindrome(left, 0, left.length() - 1)) {

                    String revRight =
                        new StringBuilder(right).reverse().toString();

                    if (map.containsKey(revRight) &&
                        map.get(revRight) != i) {
                        return true;
                    }
                }

                if (j != len &&
                    isPalindrome(right, 0, right.length() - 1)) {

                    String revLeft =
                        new StringBuilder(left).reverse().toString();

                    if (map.containsKey(revLeft) &&
                        map.get(revLeft) != i) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
