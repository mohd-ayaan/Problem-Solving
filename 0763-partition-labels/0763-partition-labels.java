class Solution {
    public List<Integer> partitionLabels(String s) {
        int n=s.length();
        HashMap<Character,Integer> mp=new HashMap<>();
        List<Integer> res=new ArrayList<>();
        int start=0,end;

        for(int i=0;i<n;i++){
            mp.put(s.charAt(i),i);
        }
        while(start<n){
            end=mp.get(s.charAt(start));
            for(int i=start+1;i<end;i++){
                end=Math.max(end,mp.get(s.charAt(i)));
            }
            res.add(end-start+1);
            start=end+1;
        }
        return res;
    }
}