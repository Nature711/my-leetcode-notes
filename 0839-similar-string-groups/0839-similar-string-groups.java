public class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSameGroup(strs[i], strs[j])) {
                    uf.union(i, j);
                }
            }
        }

        return uf.count;
    }

    public boolean isSameGroup(String leader, String str) {
        if (leader.length() != str.length()) return false;
        int count = 0;
        int[] diffPos = new int[2];
        for (int i = 0; i < leader.length(); i++) {
            if (leader.charAt(i) != str.charAt(i)) {
                if (count == 2) return false;
                diffPos[count++] = i;
            }
        }
        return count == 0 || (count == 2 && leader.charAt(diffPos[0]) == str.charAt(diffPos[1]) && leader.charAt(diffPos[1]) == str.charAt(diffPos[0]));
    }

    class UnionFind {
        int[] parent;
        int count;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            count = n;
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                count--;
            }
        }
    }
}
