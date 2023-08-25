class UnionFind {
private: 
    vector<int> roots;
    int num_of_components;
public: 
    UnionFind(int n): num_of_components(n) {
        roots.resize(n);
        for (int i = 0; i < n; i++) roots[i] = i; //initially the parent of every node is just itself
    }
    
    
    int find(int x) {
        return roots[x];
    }
    
    void union_sets(int x, int y) {
        int rx = find(x), ry = find(y);
        if (rx == ry) return;
        
        for (int i = 0; i < roots.size(); i++) {
            if (roots[i] == ry) roots[i] = rx;
        }
        num_of_components--;
        
    }
    
    int get_num_of_components() {
        return num_of_components;
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