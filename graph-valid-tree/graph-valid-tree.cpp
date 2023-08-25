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
        if (x == parents[x]) return x;
        parents[x] = find(parents[x]);
        return parents[x];
    }
    
    bool union_sets(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false;
        if (ranks[px] > ranks[py]) parents[py] = px;
        else if (ranks[px] < ranks[py]) parents[px] = py;
        else {
            parents[py] = px;
            ranks[px]++; 
        }
        
        num_of_components--;
        return true;
    }
    
    int get_num_of_components() {
        return num_of_components;
    }

};

class Solution {
public:
    bool validTree(int n, vector<vector<int>>& edges) {
        UnionFind uf(n);
        for (vector<int>& edge: edges) {
            if (!uf.union_sets(edge[0], edge[1])) return false;
        }
        return uf.get_num_of_components() == 1;
    }
};
    