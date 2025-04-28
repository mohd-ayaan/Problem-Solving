class Solution {
public:
    void dfs(vector<vector<int>>& graph, vector<vector<int>>& res,vector<int>& v, int ind)
    {
        if(ind==graph.size()-1){
            res.push_back(v);
            return;
        }

        for(int j=0;j<graph[ind].size();j++)
        {
            v.push_back(graph[ind][j]);
            dfs(graph,res,v,graph[ind][j]);  
            v.pop_back();      
        }
        

    }
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        vector<vector<int>> res;
        vector<int> v;
        v.push_back(0);
        dfs(graph,res,v,0);
        return res;
        
    }
};