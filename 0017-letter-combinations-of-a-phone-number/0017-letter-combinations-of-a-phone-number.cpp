class Solution {
public:
    vector<string> letterCombinations(string digits) {
         
        unordered_map<char, vector<char>> map;
        map['2'] = {'a', 'b', 'c'};
        map['3'] = {'d', 'e', 'f'};
        map['4'] = {'g', 'h', 'i'};
        map['5'] = {'j', 'k', 'l'};
        map['6'] = {'m', 'n', 'o'};
        map['7'] = {'p', 'q', 'r', 's'};
        map['8'] = {'t', 'u', 'v'};
        map['9'] = {'w', 'x', 'y', 'z'};
        vector<string> res;
        if (digits.length() == 0) return res;
        string curr;
        backtrack(0, digits, curr, res, map);
        return res;
    }
    
    void backtrack(int i, string& digits, string& curr, vector<string>& res, unordered_map<char, vector<char>>& map) {
        if (i == digits.length()) {
            res.push_back(curr);
            return;
        }
        
        vector<char> choices = map[digits[i]];
        for (char choice: choices) {
            curr += choice;
            backtrack(i + 1, digits, curr, res, map);
            curr.pop_back();
        }
    }
};