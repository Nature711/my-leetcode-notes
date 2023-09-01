class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> res(n + 1, 0);
        
        for (int i = 0; i <= n; i++) res[i] = count(i);
        
        return res;
    }
    
    int count(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) count++;
            n /= 2;
        }
        return count;
    }

};