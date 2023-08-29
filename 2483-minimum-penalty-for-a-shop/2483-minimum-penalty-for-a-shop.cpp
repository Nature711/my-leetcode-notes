class Solution {
public:
    int bestClosingTime(string customers) {
        int n = customers.size(), num_opens = 0, num_closed = 0;
        for (int i = 0; i < n; i++) {
            if (customers[i] == 'Y') num_opens++;
            else num_closed++;
        }
        
        int curr_penalty = num_closed, min_penalty = curr_penalty, t = n;
        
        for (int i = n - 1; i >= 0; i--) {
            if (customers[i] == 'Y') curr_penalty++;
            else curr_penalty--;
            if (curr_penalty <= min_penalty) {
                min_penalty = curr_penalty;
                t = i;
            }
        }
        
        return t;
    }
};