class Solution {

    
   public List<Integer> findMinHeightTrees(int n, int[][] edges) {
       
       // edge cases
        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++)
                centroids.add(i);
            return centroids;
        }
       
        ArrayList<Set<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++)
            neighbors.add(new HashSet<Integer>());

        for (int[] edge : edges) {
            Integer start = edge[0], end = edge[1];
            neighbors.get(start).add(end);
            neighbors.get(end).add(start);
        }
       
       
       List<Integer> leaves = new ArrayList<>();
      
     
       for (int i = 0; i < n; i++) {
           if (neighbors.get(i).size() == 1) leaves.add(i);
       }
    
       int remNodes = n;
       
       while (remNodes > 2) {
           remNodes -= leaves.size();
           List<Integer> newLeaves = new ArrayList<>();
           
           // remove the current leaves along with the edges
           for (int leaf: leaves) {

               // the only neighbor left for the leaf node
               int neighbor = neighbors.get(leaf).iterator().next();
               // remove the edge along with the leaf node (from its parent's neighbor list)
               neighbors.get(neighbor).remove(leaf);
               //if the parent's neighbor list size becomes 1, this means the parent now becomes a leaf
               if (neighbors.get(neighbor).size() == 1) newLeaves.add(neighbor);
           }
           leaves = newLeaves;
         
       }
       return leaves;
   }
}