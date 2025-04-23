class Solution {
public:
    int countLargestGroup(int n) {
        unordered_map<int,int> mp;
        int digits,num,sum;
        for(int i=0;i<n;i++){
            digits=(int)log10(i+1)+1;
            num=i+1;
            sum=0;
            while(digits--){
                sum+=num%10;
                num/=10;
            }
            mp[sum]+=1;
        }
        int maxfreq=0,count=0;;
        for(auto item:mp){
            if(item.second>maxfreq){
                maxfreq=item.second;
            }
        }
        for(auto item:mp){
            if(item.second==maxfreq){count++;}
        }
        
        return count;
    }
};