import java.util.*;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        
        // Loop over possible lengths
        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        
        for (int length = lowLen; length <= highLen; length++) {
            // Loop over possible starting digits
            for (int start = 1; start <= 9; start++) {
                int num = 0;
                for (int d = start; d < start + length; d++) {
                    if (d > 9) break; // can't go beyond digit 9
                    num = num * 10 + d;
                }
                // Check validity
                if (String.valueOf(num).length() == length && num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        
        Collections.sort(result); // ensure ascending order
        return result;
    }
}
