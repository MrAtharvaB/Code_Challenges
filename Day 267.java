class Solution {
    public int getLastDigit(String a, String b) {
        if (b.equals("0")) {
            return 1;
        }

        int base = a.charAt(a.length() - 1) - '0';

        int expMod = 0;
        for (int i = 0; i < b.length(); i++) {
            expMod = (expMod * 10 + (b.charAt(i) - '0')) % 4;
        }

        if (expMod == 0) {
            expMod = 4;
        }

        int result = 1;
        for (int i = 0; i < expMod; i++) {
            result = (result * base) % 10;
        }

        return result;
    }
}
