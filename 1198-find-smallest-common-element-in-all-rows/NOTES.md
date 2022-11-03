## HashSet "intersection"
- initialize a hashset (global set) using all elements in the first row 
- initialize a new hashset before iterate through each row starting from the second, adding into it only the element that is also present in the global set
- update the global set to be this new hashset
- we're effetively finding the intesection of all rows
- find the min element in the union result at last
- time: 
  - iterate over each row & check if set contains element --> O(n) for each row --> O(n^2) in total
  - iterate over final set at last --> O(n)
  - total time: O(n^2)

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

## Count occurences 
- by constraint that max(mat[i][j]) = 10^4, we initialize an array of size 10001, where the i-th element stores the occurences of the number i
- iterate over the matrix; update the occurences (i.e., the element) at specific indices
- iterate over the count array from start to end; the first element that equals the no. of rows is the smallest element that appears in all rows

```
    public int smallestCommonElement(int[][] mat) {
        int[] counts = new int[10001];
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                counts[mat[i][j]]++;
            }
        }
        
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == mat.length) return i;
        }
        
        return -1;
    }
```

## Binary search
- stupid & intuitive, but strangely fast
```
 public int smallestCommonElement(int[][] mat) {
        for (int i = 0; i < mat[0].length; i++) {
            boolean bool = true;
            for (int j = 1; j < mat.length; j++) {
                if (!binarySearch(mat[j], mat[0][i])) {
                    bool = false;
                    break;
                }
            }
            if (bool) return mat[0][i];
        }
        return -1;
    }
    
    public boolean binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
```

## Row positions
- haha 
```
```
