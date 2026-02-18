class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = n ^ (n >> 1);   // XOR with right-shifted version
        return (x & (x + 1)) == 0; 
    }
}
