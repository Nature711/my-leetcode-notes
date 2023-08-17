class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        queue<pair<int, int>> q;
        int m = mat.size(), n = mat[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    q.push({i, j});
                }
            }
        }
        
        vector<vector<int>> directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!q.empty()) {
            pair<int, int> cor = q.front();
            q.pop();
            int r = cor.first, c = cor.second;
            for (vector<int> dir: directions) {
                int nextR = r + dir[0], nextC = c + dir[1];
                if (nextR < m && nextR >= 0 && nextC < n && nextC >= 0 && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    mat[nextR][nextC] = mat[r][c] + 1;
                    q.push({nextR, nextC});
                }
            }
        }
        
        return mat;
    }
};