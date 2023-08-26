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
};

class Solution {
public:
    int earliestAcq(vector<vector<int>>& logs, int n) {
        
        sort(logs.begin(), logs.end(), [](auto& v1, auto& v2) { return v1[0] < v2[0]; });
             
        UnionFind uf(n);
        for (vector<int>& log: logs) {
            uf.union_sets(log[1], log[2]);
            if (uf.get_num_of_components() == 1) return log[0];
        }
        
        return -1;
    }
};