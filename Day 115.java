class Solution {
    public String removeKdig(String s, int k) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            while (stack.length() > 0 && k > 0 && stack.charAt(stack.length() - 1) > c) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(c);
        }

        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        int idx = 0;
        while (idx < stack.length() && stack.charAt(idx) == '0') {
            idx++;
        }

        if (idx == stack.length()) return "0";
        return stack.substring(idx);
    }
}
