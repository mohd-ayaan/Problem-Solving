class Solution {
public:
    void DFS(vector<vector<int>>& image, int row, int col, int color, int stcolor){
        if(row<0 || row>=image.size() || col<0 || col>=image[0].size() || image[row][col]!=stcolor ||image[row][col]==color){return;}

        image[row][col]=color;
        DFS(image,row-1,col,color,stcolor);
        DFS(image,row,col+1,color,stcolor);
        DFS(image,row+1,col,color,stcolor);
        DFS(image,row,col-1,color,stcolor);
        
    }
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int stcolor=image[sr][sc];
        DFS(image,sr,sc,color,stcolor);
        return image;
    }
};