class Solution {
public:
    int possible(vector<int>& bloomDay, int day, int m, int k){
        int cnt=0, bouquet=0;
        int n=bloomDay.size();
        for(int i=0;i<n;i++){
            if(bloomDay[i]<=day){cnt++;}
            else{
                bouquet+=cnt/k;
                cnt=0;
            }
        }
        bouquet+=cnt/k;
        return bouquet>=m?1:0;

    }
    int minDays(vector<int>& bloomDay, int m, int k) {
        int l=*min_element(bloomDay.begin(),bloomDay.end());
        int h=*max_element(bloomDay.begin(),bloomDay.end());

        int res=-1;
        while(l<=h){
            int day=(l+h)/2;
            if(possible(bloomDay,day,m,k)){
                res=day;
                h=day-1;
            }
            else{
                l=day+1;
            }
        }
        return res;
    }
};