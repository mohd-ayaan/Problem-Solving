class Solution {
public:
    // DFS
    // void dfs(vector<vector<int>>& graph, vector<vector<int>>& res,vector<int>& v, int ind)
    // {
    //     if(ind==graph.size()-1){
    //         res.push_back(v);
    //         return;
    //     }

    //     for(int j=0;j<graph[ind].size();j++)
    //     {
    //         v.push_back(graph[ind][j]);
    //         dfs(graph,res,v,graph[ind][j]);  
    //         v.pop_back();      
    //     }
        

    // }
    // vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
    //     vector<vector<int>> res;
    //     vector<int> v;
    //     v.push_back(0);
    //     dfs(graph,res,v,0);
    //     return res;
        
    // }

    // BFS
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
    int n = graph.size();
    vector<vector<int>> result;
    queue<vector<int>> q;

    q.push({0});

    while (!q.empty()) {
        vector<int> path = q.front();
        q.pop();
        int lastNode = path.back();

        if (lastNode==n-1) {
            result.push_back(path);
        }
        else{
            for (int neighbor : graph[lastNode]) {
                vector<int> newPath(path);
                newPath.push_back(neighbor); 
                q.push(newPath);
            }
        }
    }

    return result;
}
};