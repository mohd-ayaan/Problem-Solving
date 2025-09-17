class Solution {
    public boolean dfs(List<List<Integer>> adj, int source, int destination, boolean[] visited) {
        if (source == destination) return true;
        if (visited[source]) return false;

        visited[source] = true;

        for (int neighbor : adj.get(source)) {
            if (dfs(adj, neighbor, destination, visited)) {
                return true;
            }
        }

        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        return dfs(adj, source, destination, visited);
    }
}
