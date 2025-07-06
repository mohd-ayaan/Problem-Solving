class Solution {
public:
    // int func(vector<int> piles, int mid){
    //     int n=piles.size();
    //     int hours=0;
    //     for(int i=0;i<n;i++){
    //         hours+=(piles[i]+mid-1)/mid;  
    //     }
    //     return hours;
    // }
    int minEatingSpeed(vector<int>& piles, int h) {
        int n=piles.size();
        int max_ele=*max_element(piles.begin(),piles.end());
        int res=max_ele;
        int low=1, high=max_ele;
        while(low<=high){
          long long mid=low+(high-low)/2;

          long long hours=0;
          for (int pile : piles)
            hours += (pile + mid - 1) / mid;
            
          if(hours<=h){
            res=mid;
            high=mid-1;
          }
   
          else{
              low=mid+1;
          }
        }
        return res;
    }
};