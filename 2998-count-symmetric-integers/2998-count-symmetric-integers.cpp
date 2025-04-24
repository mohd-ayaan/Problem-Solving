class Solution {
public:
    int countSymmetricIntegers(int low, int high) {
        int num,len,count=0;
        for(int i=low;i<=high;i++){
            len=log10(i)+1;
            if(len%2!=0){continue;}
            int lsum=0,rsum=0;
            num=i;
            for(int j=0;j<len/2;j++){
                rsum+=num%10;
                num/=10;
            }
            for(int j=0;j<len/2;j++){
                lsum+=num%10;
                num/=10;
            }
            if(lsum==rsum){count++;}
        }
        return count;
    }
};