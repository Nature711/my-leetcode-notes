class UnionFind {
private: 
    vector<int> parents;
    int num_of_components;
public: 
    UnionFind(int n): num_of_components(n) {
        parents.resize(n);
        for (int i = 0; i < n; i++) parents[i] = i;
    }
    
    int find(int x) {
        int rx = x;
        
        while (parents[rx] != rx) {
            rx = parents[rx];
        }
        
        return rx;
    }
    
    void union_sets(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return;
        parents[py] = px;
        
        num_of_components--;
    }
    
    int get_num_of_components() {
        return num_of_components;
    }
    
    bool is_connected(int x, int y) {
        return find(x) == find(y);
    }
};

class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        UnionFind uf(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) uf.union_sets(i, j);
            }
        }
        return uf.get_num_of_components();
    }
};