## HashMap 
- hashmap: map of number to its occurences
- iterate over each row, counting the occurence of each element
- extract those numbers whose occurence == no. of rows
- sort result list at last
- time: O(n^2) + O(NlogN) = O(n^2)

```
  public int smallestCommonElement(int[][] mat) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: mat[0]) set.add(num);
        
        for (int i = 1; i < mat.length; i++) {
            HashSet<Integer> newSet = new HashSet<>();
            for (int j = 0; j < mat[0].length; j++) {
                if (set.contains(mat[i][j])) newSet.add(mat[i][j]);
            }
            set = newSet;
        }
        
        int min = Integer.MAX_VALUE;
        for (int num: set) min = Math.min(min, num);
        
        return min == Integer.MAX_VALUE ? -1: min;
    }
    
```

## Array 
- instead of using a hashmap to keep track the occurences, we can use a fixed size array
 - each index refers to a specific number
 - number at that index refers to the occurences
- what should be the array size? 
 - approach 1: 
   - ased on the constraint that max(total no. of matrix elements) = 1000 and max(matrix[i][j]) = 1000
   - initialize an array of size 1000, where the i-th idx stores the occurence of number i
 - apporach 2: 
   - iterate over the matrix once to find out the [min, max] range
   - initialize an array of size (max - min + 1), where the i-th idx stores the occurence of number (i - min)
   - this is done by iterating over the matrix; when encountering the number X, we increment the number at idx (X - min), which by definition, represents the occurences of the number X
   - at last we iterate over the array; when encountering an element (at idx i for example) that equals the total no. of rows, we know this means the number (i + min) has occured for (no. of rows) times, which can only happen if it occurs once in each row (i.e., being a common element of all rows), since each row contains distinct numbers
   - meanwhile the result is guareenteed to be sorted in ascending order 
   
```
   public List<Integer> intersection(int[][] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i =0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                if(nums[i][j]<min){
                    min = nums[i][j];
                }
                if(nums[i][j]>max){
                    max = nums[i][j];
                }
            }
        }
        int[] ans = new int[max-min+1];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                ans[nums[i][j]-min]++;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<ans.length;i++){
            if(ans[i]==nums.length){
                res.add(i+min);
            }
        }
        return res;
    }
 ```
