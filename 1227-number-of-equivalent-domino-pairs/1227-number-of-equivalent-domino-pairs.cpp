class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        unordered_map<int, int> count;
        int pairs = 0;

        for (const auto& d : dominoes) {
            // Unique key for each equivalent pair
            int key = min(d[0], d[1]) * 10 + max(d[0], d[1]); 
            cout<<d[0]<<" "<<count[key]<<endl; 
            pairs += count[key];
            count[key]++;
        }

        return pairs;
    }
};