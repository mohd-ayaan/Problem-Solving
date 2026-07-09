class Solution {
    public int jump(int[] nums) {
        int jumps = 0;        // number of jumps taken
        int currentEnd = 0;   // end of the current range
        int farthest = 0;     // farthest index we can reach

        for (int i = 0; i < nums.length - 1; i++) {
            // update the farthest we can reach from this index
            farthest = Math.max(farthest, i + nums[i]);

            // if we’ve reached the end of the current range,
            // we must make a jump
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}
