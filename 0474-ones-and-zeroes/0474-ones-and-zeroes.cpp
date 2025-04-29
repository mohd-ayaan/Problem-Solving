class Solution {
public:
    vector<int> count(vector<string>& strs, int ind){
        int z=0,o=0;
        for(char ch:strs[ind]){
            if(ch=='0'){z++;}
            else{o++;}
        }
        return {z,o};
    }
    int func(vector<string>& strs, int m, int n,int ind, vector<vector<vector<int>>>& memo){
        if(ind<0){return 0;}

        if(memo[ind][m][n]!=-1){return memo[ind][m][n];}

        vector<int> c=count(strs,ind);
        int not_take=0+func(strs,m,n,ind-1,memo);
        int take=0;
        if(m>=c[0] && n>=c[1]){
            take=1+func(strs,m-c[0],n-c[1],ind-1,memo);
        }
        return memo[ind][m][n] = max(take, not_take);

    }

    int findMaxForm(vector<string>& strs, int m, int n){
        int k=strs.size();
        vector<vector<vector<int>>> memo(k, vector<vector<int>>(m + 1, vector<int>(n + 1,-1)));
        return func(strs,m,n,k-1,memo);
    }
};