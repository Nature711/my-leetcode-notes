class Solution {
public:
    double champagneTower(int poured, int query_row, int query_glass) {
        vector<double> curr_row = { (double) poured };
        int curr_row_idx = 0;
        while (curr_row_idx < query_row) {
            vector<double> next_row(curr_row.size() + 1);
            bool updated = false;
            for (int j = 0; j < curr_row.size(); j++) {
                double curr_row_before = curr_row[j];
                curr_row[j] = min(curr_row[j], 1.00);
                double excess = curr_row_before - curr_row[j];
                if (excess >= 0.00) {
                    next_row[j] += excess / 2.00;
                    next_row[j + 1] += excess / 2.00;
                    updated = true;
                }
            }
            if (!updated) break;
            curr_row = next_row;
            curr_row_idx++;
        }
        return min(1.00, curr_row[query_glass]);
    }
};