class Solution {
public:
    string convertToTitle(int columnNumber) {
        string res;
        while (columnNumber > 0) {
            columnNumber -= 1;
            int digit = columnNumber % 26;  
            res +=(char)(digit + 65);
            columnNumber /= 26;
        }
        reverse(res.begin(), res.end()); 
        return res;
    }
};   