class Solution {
   
    public int removeStones(int[][] stones) {
        
        int n = stones.length;
        
        UnionFind uf = new UnionFind(n);
        
        Arrays.sort(stones, (s1, s2) -> {
            int diff = s1[0] - s2[0];
            return diff == 0 ? s1[1] - s2[1] : diff;
        });
        
        int low = stones[0][0], high = stones[n - 1][1];
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j && 
                    (stones[i][0] == stones[j][0] //share the same row
                    || stones[i][1] == stones[j][1])) //share the same column
                    uf.union(i, j);
                    // System.out.println(uf.numOfComponets);
            }
        }
        
        return n - uf.numOfComponets;
    }
    
}

public class UnionFind {
    private int[] parents;
    private int[] size;
    int numOfComponets = 0;

    public UnionFind(int n) {
        parents = new int[n];
        size = new int[n];
        numOfComponets = n;
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public int find(int cur) {
        int root = cur;
        while (root != parents[root]) {
            root = parents[root];
        }
        // Path Compression
        while (cur != root) {
            int preParent = parents[cur];
            parents[cur] = root;
            cur = preParent;
        }
        return root;
    }

    public int findComponentSize(int cur) {
        int parent = find(cur);
        return size[parent];
    }

    public void union(int node1, int node2) {
        int node1Parent = find(node1);
        int node2Parent = find(node2);

        if (node1Parent == node2Parent)
            return;

        if (size[node1Parent] > size[node2Parent]) {
            parents[node2Parent] = node1Parent;
            size[node1Parent] += size[node2Parent];
        } else {
            parents[node1Parent] = node2Parent;
            size[node2Parent] += size[node1Parent];
        }
        numOfComponets--;
    }
}