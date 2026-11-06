class Solution {
    boolean[] visited;
    public void DFS(int u,int[][] isConnected, boolean[] visited){
        visited[u]=true;

        for(int i=0;i<isConnected.length;i++){
            if(isConnected[u][i]==1 && !visited[i]){
                DFS(i,isConnected, visited);
            }
        }

    }
    public int findCircleNum(int[][] isConnected) {
        int v=isConnected.length;
        visited=new boolean[v];

        int provinces=0;
        for(int i=0;i<v;i++){
            if(!visited[i]){
                DFS(i,isConnected, visited);
                provinces+=1;
            }
        }
        return provinces;
    }
}