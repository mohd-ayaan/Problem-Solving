class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n=people.length;
        Arrays.sort(people);
        int l=0,r=n-1,res=0;
        while(l<=r){
            int first=people[r];
            System.out.println(first);

            if(r!=l && first+people[l]<=limit){
                l++;
            } 
            r--;
            res+=1;
        }
        return res;
    }
}