class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        List<List<Integer>> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (res.size() == k) {
                break;
            }
            res.add(new ArrayList<>(Arrays.asList(nums1[i], nums2[j])));

            if (i == n - 1 || j == m - 1) {
                break;
            }
            if (nums1[i + 1] == nums2[j + 1]) {
                if (nums1[i] < nums2[j]) {
                    j++;
                } else {
                    i++;
                }

            } else if (nums1[i + 1] < nums2[j + 1]) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}