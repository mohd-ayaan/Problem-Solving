class Solution {
    public static boolean isPossible(int[] target) {
        // Edge case: single element
        if (target.length == 1) {
            return target[0] == 1;
        }

        // Max-heap using PriorityQueue with reverse order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long totalSum = 0;

        for (int num : target) {
            totalSum += num;
            maxHeap.offer(num);
        }

        while (!maxHeap.isEmpty()) {
            int largest = maxHeap.poll(); // Get largest element
            long restSum = totalSum - largest; // Sum of remaining elements

            // If largest is 1 or restSum is 1, we can finish
            if (largest == 1 || restSum == 1) {
                return true;
            }

            // Invalid cases
            if (restSum == 0 || largest < restSum) {
                return false;
            }

            // Reverse step: find previous value of largest
            long prevValue = largest % restSum;
            if (prevValue == 0) {
                return false;
            }

            // Update heap and total sum
            totalSum = restSum + prevValue;
            maxHeap.offer((int) prevValue);
        }
        return true;
    }
}