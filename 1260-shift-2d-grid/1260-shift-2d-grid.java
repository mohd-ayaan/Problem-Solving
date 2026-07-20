class Solution {
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        // Flatten into 1D list
        List<Integer> flat = new ArrayList<>();
        for (int[] row : grid) {
            for (int val : row) {
                flat.add(val);
            }
        }

        // Create shifted list
        //pre‑allocate a list of size total filled with zeros.
        List<Integer> shifted = new ArrayList<>(Collections.nCopies(total, 0));
        for (int i = 0; i < total; i++) {
            shifted.set((i + k) % total, flat.get(i));
        }

        // Convert back to 2D ArrayList
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(shifted.get(i * n + j));
            }
            result.add(row);
        }

        return result;
    }
}

