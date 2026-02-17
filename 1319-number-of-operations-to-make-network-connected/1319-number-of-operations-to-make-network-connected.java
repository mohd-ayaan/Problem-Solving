class Solution {
    public void dfs(List<List<Integer>> adj, int node, boolean[] visited) {
        visited[node] = true;
        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                dfs(adj, nei, visited);
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        // Step 1: Check if enough edges exist
        if (connections.length < n - 1)
            return -1;

        // Step 2: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : connections) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Step 3: Count connected components
        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(adj, i, visited);
            }
        }

        // Step 4: Minimum operations = components - 1
        return components - 1;
    }
}
