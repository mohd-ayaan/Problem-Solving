class Solution {
    public String largestPalindromic(String num) {
        int[] freq = new int[10];
        for (char c : num.toCharArray()) {
            freq[c - '0']++;
        }

        StringBuilder prefix = new StringBuilder();

        // Build prefix from highest digits
        for (int i = 9; i >= 0; i--) {
            while (freq[i] >= 2) {
                prefix.append((char) ('0' + i));
                freq[i] -= 2;
            }
        }

        // Find centre (largest remaining digit)
        String centre = "";
        for (int i = 9; i >= 0; i--) {
            if (freq[i] > 0) {
                centre = String.valueOf((char) ('0' + i));
                break;
            }
        }

        // Build suffix as reverse of prefix
        String suffix = new StringBuilder(prefix).reverse().toString();

        // Avoid leading zeros
        if (prefix.length() == 0 && centre.equals("")) {
            return "0";
        }

        if (prefix.length() > 0 && prefix.charAt(0) == '0') {
            return centre.isEmpty() ? "0" : centre;
        }

        return prefix.toString() + centre + suffix;
    }
}
