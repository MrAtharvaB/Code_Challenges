class Solution {
    String URLify(String s) {
        StringBuilder result = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                result.append("%20");
            } else {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}
