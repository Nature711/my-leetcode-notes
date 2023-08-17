class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        queue<pair<int, int>> q;
        int m = mat.size(), n = mat[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        vector<vector<int>> res(m, vector<int>(n, 0));
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    q.push({i, j});
                }
            }
        }
        
        vector<vector<int>> directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        int level = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int t = 0; t < size; t++) {
                pair<int, int> cor = q.front();
                q.pop();
                int i = cor.first, j = cor.second;
                if (mat[i][j] == 1) res[i][j] = level;
                for (vector<int> dir: directions) {
                    int nextR = i + dir[0], nextC = j + dir[1];
                    if (nextR < m & nextR >= 0 && nextC < n && nextC >= 0 && !visited[nextR][nextC]) {
                        visited[nextR][nextC] = true;
                        q.push({nextR, nextC});
                    }
                }
            }
            level++;
        }
        
        return res;
    }
};