class Solution {
    // helper class to store pass & total and compute gain
    private static class ClassInfo {
        int pass;
        int total;

        ClassInfo(int p, int t) {
            this.pass = p;
            this.total = t;
        }

        double ratio() {
            return (double) pass / total;
        }

        double gain() {
            // gain if we add one passing student
            return (double) (pass + 1) / (total + 1)
                    - (double) pass / total;
        }

        void addStudent() {
            pass++;
            total++;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // max-heap ordered by gain if we add one more passing student
        PriorityQueue<ClassInfo> pq = new PriorityQueue<>(
                (x, y) -> Double.compare(y.gain(), x.gain()));

        for (int[] c : classes) {
            pq.offer(new ClassInfo(c[0], c[1]));
        }

        // distribute extra students greedily
        while (extraStudents-- > 0) {
            ClassInfo best = pq.poll(); // class with max gain
            best.addStudent(); // add one passing student
            pq.offer(best); // push back with updated gain
        }

        // compute final average
        double sum = 0.0;
        int n = classes.length;
        while (!pq.isEmpty()) {
            ClassInfo c = pq.poll();
            sum += c.ratio();
        }
        return sum / n;
    }

}