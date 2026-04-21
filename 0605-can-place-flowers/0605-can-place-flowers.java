class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int bedlen=flowerbed.length;
        
        if(n==0)return true;
        if(n==1){
            if(bedlen==1){return flowerbed[0]==0?true:false;}
            if(bedlen==2 && flowerbed[0]==0 && flowerbed[1]==0){return true;}
        }
        if(n==2 && bedlen==2){return false;}

        if(flowerbed[0]==0 && flowerbed[1]==0){
            flowerbed[0]=1;
            n--;
        }

        int i=1;
        while(n>0){
            if(i>=bedlen-1){break;}

            if(flowerbed[i]==0){
                if(flowerbed[i-1]==0 && flowerbed[i+1]==0){
                    flowerbed[i]=1;
                    n--;
                }
            }

            i++;
        }

        if(flowerbed[bedlen-1]==0 && flowerbed[bedlen-2]==0){
            flowerbed[bedlen-1]=1;
            n--;
        }

        if(n<=0){return true;}
        return false;
    }
}