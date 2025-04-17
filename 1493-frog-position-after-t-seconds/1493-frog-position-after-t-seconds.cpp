class Solution {
public:
    double dfs(unordered_map<int, vector<int>>& graph, unordered_set<int>& visited, int node, double probability, int timeleft, int target) {
        if (timeleft < 0) {
            return 0.0;
        }
        if (timeleft == 0) {
            return node == target ? probability : 0.0;
        }
        
        visited.insert(node);
        int childrenCount = 0;
        for (int neighbor : graph[node]) {
            if (visited.find(neighbor) == visited.end()) {
                childrenCount++;
            }
        }
        
        if (childrenCount == 0) {
            return node == target ? probability : 0.0;
        }
        
        double result = 0.0;
        for (int neighbor : graph[node]) {
            if (visited.find(neighbor) == visited.end()) {
                result += dfs(graph, visited, neighbor, probability / childrenCount, timeleft - 1, target);
            }
        }
        visited.erase(node);
        return result;
    }
    
    double frogPosition(int n, vector<vector<int>>& edges, int t, int target) {
        if (n == 1 && t <= n) {
            return 1.00;
        }
        unordered_map<int, vector<int>> graph;
        for (auto& edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        unordered_set<int> visited;
        return dfs(graph, visited, 1, 1.0, t, target);
    }
};
