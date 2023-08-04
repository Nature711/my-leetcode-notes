class Solution {
public:
    double champagneTower(int poured, int query_row, int query_glass) {
        double cups[query_row + 1][query_row + 1];
        for (int i = 0; i < query_row + 1; i++) {
            for (int j = 0; j < query_row + 1; j++) {
                cups[i][j] = 0.00;
            }
        }
        cups[0][0] = (double) poured;
        
        for (int i = 0; i < query_row; i++) { //for each row i
            for (int j = 0; j <= i; j++) { //for each cup j in row i
                double rem = max(0.00, cups[i][j] - 1);
                cups[i + 1][j] += rem / 2;
                cups[i + 1][j + 1] += rem / 2;
            }
        }
        return min(1.00, cups[query_row][query_glass]);
    }
};