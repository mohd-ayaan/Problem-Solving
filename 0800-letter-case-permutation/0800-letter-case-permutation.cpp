class Solution {
public:
    void backtrack(string s, int i, vector<string>& res, string str) {
        if (i == s.size()) {
            res.push_back(str);
            return;
        }
        
        if (isalpha(s[i])) {
            backtrack(s, i + 1, res, str + (char)toupper(s[i]));
            backtrack(s, i + 1, res, str + (char)tolower(s[i]));
        } else {
            backtrack(s, i + 1, res, str + s[i]);
        }
    }

    vector<string> letterCasePermutation(string s) {
        vector<string> res;
        backtrack(s, 0, res, "");
        return res;
    }
};