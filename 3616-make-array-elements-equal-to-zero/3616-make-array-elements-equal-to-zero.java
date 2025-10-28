class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) continue;

            // Try both directions
            if (simulate(nums, i, false)) count++;
            if (simulate(nums, i, true)) count++;
        }

        return count;
    }

    private boolean simulate(int[] nums, int start, boolean directionRight) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        int curr = start;
        boolean dir = directionRight;

        while (curr >= 0 && curr < arr.length) {
            if (arr[curr] == 0) {
                curr = dir ? curr + 1 : curr - 1;
            } else {
                arr[curr]--;
                dir = !dir;
                curr = dir ? curr + 1 : curr - 1;
            }
        }

        for (int val : arr) {
            if (val != 0) return false;
        }

        return true;
    }
}
