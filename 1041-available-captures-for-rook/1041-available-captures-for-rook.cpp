class Solution {
public:
    int numRookCaptures(vector<vector<char>>& board) {
        int n=board.size();
        int m=board[0].size();
        int a,b,p,q,count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='R')
                {
                    a=i;
                    b=j;
                    break;
                }
            }
        }
        p=a-1;
        for(int i=p;i>=0;i--){
            cout<<i<<" "<<b<<endl;
            if(board[i][b]=='p'){
                count++;
                cout<<i<<" "<<b<<endl;
                break;
            }
            if(board[i][b]=='B'){break;}
        }

        p=a+1;
        for(int i=p;i<n;i++){
            if(board[i][b]=='p'){
                count++;
                cout<<i<<" "<<b<<endl;
                break;
            }
            if(board[i][b]=='B'){break;}
        }

        p=a,q=b-1;
        for(int j=q;j>=0;j--){
            if(board[p][j]=='p'){
                count++;
                cout<<p<<" "<<j<<endl;
                break;
            }
            if(board[p][j]=='B'){break;}
        }

        q=b+1;
        for(int j=q;j<m;j++){
            if(board[p][j]=='p'){
                count++;
                cout<<p<<" "<<j<<endl;
                break;
            }
            if(board[p][j]=='B'){break;}
        }
        return count;

    }
};