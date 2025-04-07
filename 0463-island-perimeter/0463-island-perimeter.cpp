class Solution {
public:
    
    int DFS(vector<vector<int>>& grid, vector<vector<bool>>& visited, int i, int j)
    {
        if(i<0 || i>=grid.size() || j<0 || j>=grid[0].size() || grid[i][j]==0){return 1;}

        if(visited[i][j]==true){return 0;}

        int res=0;
        visited[i][j]=true;
        res+=DFS(grid, visited, i-1,j);
        res+=DFS(grid, visited, i,j-1);
        res+=DFS(grid, visited, i+1,j);
        res+=DFS(grid, visited, i,j+1);
        return res;
    }

    int islandPerimeter(vector<vector<int>>& grid) {
        int n=grid.size();
        int m=grid[0].size();
        vector<vector<bool>> visited(n, vector<bool>(m, false));
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(visited[i][j]==false && grid[i][j]==1)
                {
                    return DFS(grid,visited,i,j);
                }
            }
        }
        return 0;

    }
};