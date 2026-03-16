//Ineffecient-sorting(nlogn)
// class SummaryRanges {
//     List<Integer> arr;
//     public SummaryRanges() {
//         arr=new ArrayList<>();
//     }
    
//     public void addNum(int value) {
//         arr.add(value);
//         Collections.sort(arr);
//     }
    
//     public int[][] getIntervals() {
//         List<int[]> res=new ArrayList<>();
//         int i=0,j,n=arr.size();
//         while(i<n){
//             j=i;
//             while(j<n-1 && (arr.get(j+1)==arr.get(j)+1 || arr.get(j+1)==arr.get(j))){j++;}
//             res.add(new int[]{arr.get(i),arr.get(j)});
//             i=j+1;
//         }
//         return res.toArray(new int[res.size()][]);
//     }
// }


//)(Treeset sorting-logn) and get query-O(n)
class SummaryRanges {
    private TreeSet<Integer> set;

    public SummaryRanges() {
        set = new TreeSet<>();
    }

    public void addNum(int value) {
        set.add(value); // O(log n), no duplicates
    }

    public int[][] getIntervals() {
        List<int[]> res = new ArrayList<>();
        Integer start = null, end = null;
        for (int num : set) {
            if (start == null) {
                start = end = num;
            } else if (num == end + 1) {
                end = num; // extend interval
            } else {
                res.add(new int[]{start, end});
                start = end = num; // new interval
            }
        }
        if (start != null) res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */