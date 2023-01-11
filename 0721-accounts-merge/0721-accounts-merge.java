class Solution {
    List<HashSet<String>> accountInfo = new ArrayList<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (List<String> acc: accounts) {
            HashSet<String> account = new HashSet<>();
            for (int i = 1; i < acc.size(); i++) account.add(acc.get(i));
            accountInfo.add(account);
        }
        
        //System.out.println(accountInfo);
        
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                List<String> acc1 = accounts.get(i);
                List<String> acc2 = accounts.get(j);
                //System.out.println("acc1 is " + acc1.get(0) + " and acc2 is " + acc2.get(0));
                if (acc1.get(0).equals(acc2.get(0))) {
                    boolean hasIntersection = hasIntersection(i, j);
                    
                    if (hasIntersection) {
                        //System.out.println(i + " and " + j + " has intersection and are unioned");
                        uf.union(i, j);
                    }
                }
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                List<String> acc1 = accounts.get(i);
                List<String> acc2 = accounts.get(j);
                //System.out.println("acc1 is " + acc1.get(0) + " and acc2 is " + acc2.get(0));
                if (acc1.get(0).equals(acc2.get(0))) {
                    boolean hasIntersection = hasIntersection(i, j);
                    
                    if (hasIntersection) {
                        //System.out.println(i + " and " + j + " has intersection and are unioned");
                        uf.union(i, j);
                    }
                }
            }
        }
        
        
        List<List<String>> res = new ArrayList<>();
        
        HashMap<Integer, HashSet<String>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
  
            if (map.containsKey(uf.parents[i])) {
                HashSet<String> existingAccounts = map.get(uf.parents[i]);
                for (String s: accountInfo.get(i)) existingAccounts.add(s);
            } else {
                HashSet<String> newAccount = new HashSet<>();
                for (String s: accountInfo.get(i)) newAccount.add(s);
                map.put(uf.parents[i], newAccount);
            }
        }
        
        for (int key: map.keySet()) {
            List<String> union = new ArrayList<>();
            
            for (String s: map.get(key)) union.add(s);
            Collections.sort(union);
            union.add(0, accounts.get(key).get(0));
            res.add(union);
        }
        
        return res;
    }
    
    public boolean hasIntersection(int i, int j) {
        HashSet<String> acc1 = accountInfo.get(i);
        HashSet<String> acc2 = accountInfo.get(j);
        for (String s: acc1) if (acc2.contains(s)) return true; 
        return false;
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