class UnionFind {
private: 
    vector<int> parents;
    int num_of_components;
    vector<int> ranks;
public: 
    UnionFind(int n): num_of_components(n) {
        parents.resize(n);
        ranks.resize(n);
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }
    }
    
    int find(int x) {
        if (parents[x] == x) return x;
        parents[x] = find(parents[x]);
        return parents[x];
    }
    
    void union_sets(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return;
        if (ranks[px] > ranks[py]) parents[py] = px;
        else if (ranks[px] < ranks[py]) parents[px] = py;
        else {
            parents[py] = px;
            ranks[px]++;
        }
        
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