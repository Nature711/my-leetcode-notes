class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                int distance = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                edges.add(new int[] {distance, i, j});
            }
        }
        
        Collections.sort(edges, (e1, e2) -> e1[0] - e2[0]);
        
        UnionFind uf = new UnionFind(n);
        int totalCost = 0;
        int numEdges = 0;
        
        for (int[] edge: edges) {
            if (numEdges == n - 1) break;
            int cost = edge[0], p1 = edge[1], p2 = edge[2];
            if (uf.union(p1, p2)) {
                numEdges++;
                totalCost += cost;
            }
            
        }
        
        return totalCost;
    }
}

public class UnionFind {
    int[] parents;
    int[] size;
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

    public boolean union(int node1, int node2) {
        //whether union operation is succussful
        int node1Parent = find(node1);
        int node2Parent = find(node2);

        if (node1Parent == node2Parent)
            return false;

        if (size[node1Parent] > size[node2Parent]) {
            parents[node2Parent] = node1Parent;
            size[node1Parent] += size[node2Parent];
        } else {
            parents[node1Parent] = node2Parent;
            size[node2Parent] += size[node1Parent];
        }
        numOfComponets--;
        return true;
    }
}
