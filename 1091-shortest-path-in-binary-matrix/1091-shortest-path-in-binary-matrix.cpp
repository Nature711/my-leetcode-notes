class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        int n = grid.size();
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        
        vector<vector<int>> directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        
        queue<pair<int, int>> q;
        q.push({0, 0});
        grid[0][0] = 2; //mark as visited
        int steps = 1;
        
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                pair<int, int> curr = q.front();
                q.pop();
                int r = curr.first, c = curr.second;
                if (r == n - 1 && c == n - 1) return steps;

                for (vector<int>& dir: directions) {
                    int next_r = r + dir[0], next_c = c + dir[1];

                    if (next_r >= 0 && next_c >= 0 && next_r < n && next_c < n && grid[next_r][next_c] == 0) {
                        
                        q.push({next_r, next_c});
                        grid[next_r][next_c] = 2;
                    }
                }
            }
            
            steps++;
        }
        
        return -1;
        
    }
};