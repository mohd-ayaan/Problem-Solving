class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer,Integer> map1=new HashMap<>();
        Map<Integer,Integer> map2=new HashMap<>();

        for(int ele:basket1){
            map1.put(ele,map1.getOrDefault(ele,0)+1);
        }

        for(int ele:basket2){
            int freq=map1.getOrDefault(ele,0);
            if(freq==0){
                map2.put(ele,map2.getOrDefault(ele,0)+1);
            }
            else if(freq==1){
                map1.remove(ele);
            }
            else{
                map1.put(ele,freq-1);
            }
        }

        // If both maps empty → already equal
        if(map1.isEmpty() && map2.isEmpty()) return 0;

        // Collect mismatches
        List<Integer> mismatch = new ArrayList<>();
        for(Map.Entry<Integer,Integer> e: map1.entrySet()){
            if(e.getValue() % 2 != 0) return -1; // impossible
            for(int i=0;i<e.getValue()/2;i++) mismatch.add(e.getKey());
        }
        for(Map.Entry<Integer,Integer> e: map2.entrySet()){
            if(e.getValue() % 2 != 0) return -1; // impossible
            for(int i=0;i<e.getValue()/2;i++) mismatch.add(e.getKey());
        }

        // Sort mismatches
        Collections.sort(mismatch);

        // Find global minimum fruit
        int globalMin = Integer.MAX_VALUE;
        for(int x: basket1) globalMin = Math.min(globalMin, x);
        for(int x: basket2) globalMin = Math.min(globalMin, x);

        // Calculate cost
        long res = 0;
        for(int i=0;i<mismatch.size()/2;i++){
            res += Math.min(mismatch.get(i), 2*globalMin);
        }

        return res;
    }
}
