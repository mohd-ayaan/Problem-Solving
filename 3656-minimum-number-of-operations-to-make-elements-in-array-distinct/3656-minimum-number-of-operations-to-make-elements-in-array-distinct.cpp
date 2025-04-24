// class Solution {
// public:
//     int minimumOperations(vector<int>& nums) {
//         int n=nums.size();
//         if(n<3){return 1;}

//         vector<int> v(nums.begin(),nums.begin()+3);

//         int count=0;
//         for(int i=3;i<n;i=i+3){
//             if(v.find(nums[i],nums.begin()+i,nums.end())==nums.end()){
//                 return count;
//             }

//         }    
        
//     }
// };


class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        int n=nums.size();
        unordered_set<int> st;
        int rem=n%3,i=n-1;
        int res=rem?n/3+1:n/3;
        // cout<<res<<endl;
        if(rem==2){
            if(nums[n-1]==nums[n-2]){
                return res;
            }
            else{
                res-=1;
                i-=2;
                st.insert(nums[n-1]);
                st.insert(nums[n-2]);
            }
        }
        else if(rem==1){
            st.insert(nums[n-1]);
            res-=1;
            i-=1;
        }

        for(int j=i;j>=0;j-=3){
            if(nums[j]==nums[j-1] || nums[j-1]==nums[j-2] || nums[j]==nums[j-2]){return res;}

            else if(st.find(nums[j])!=st.end()){return res;}
            else if(st.find(nums[j-1])!=st.end()){return res;}
            else if(st.find(nums[j-2])!=st.end()){return res;}

            else{
                st.insert(nums[j]);
                st.insert(nums[j-1]);
                st.insert(nums[j-2]);
                
                res-=1;
            }
                 
        }
        return res;
        
        
    }
};