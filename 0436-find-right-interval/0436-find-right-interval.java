class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];

        // Max-heap for starts: (start, index)
        PriorityQueue<int[]> startHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // Max-heap for ends: (end, index)
        PriorityQueue<int[]> endHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Fill heaps
        for (int i = 0; i < n; i++) {
            startHeap.offer(new int[] { intervals[i][0], i });
            endHeap.offer(new int[] { intervals[i][1], i });
        }

        // Process intervals by largest end first
        while (!endHeap.isEmpty()) {
            int[] endEntry = endHeap.poll();
            int end = endEntry[0];
            int endIndex = endEntry[1];

            // Default: no right interval
            result[endIndex] = -1;

            // Find smallest start >= end
            if (!startHeap.isEmpty() && startHeap.peek()[0] >= end) {
                int[] startEntry = startHeap.poll();

                // Keep popping until we find the smallest start >= end
                while (!startHeap.isEmpty() && startHeap.peek()[0] >= end) {
                    startEntry = startHeap.poll();
                }

                result[endIndex] = startEntry[1];

                // Push back the last popped start
                startHeap.offer(startEntry);
            }
        }

        return result;
    }
}