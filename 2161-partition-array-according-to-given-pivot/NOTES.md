## Naive approach

- Create two separate arraylists ```small``` and ```large```, to store the elements lesser and greater than pivot respectively;
- Count the number of pivots and put them in between the ```small``` and ```large``` array when constructing the final answer;

```
 public int[] pivotArray(int[] nums, int pivot) {
        int len = nums.length;
        
        List<Integer> small = new ArrayList<>();
        List<Integer> large = new ArrayList<>();
        int pivotCount = 0;
        
        for (int i = 0; i < len; i++) {
            if (nums[i] == pivot) {
                pivotCount++;
            } else if (nums[i] < pivot) {
                small.add(nums[i]);
            } else {
                large.add(nums[i]);
            }
        }
        
        int i = 0;
        for (int j = 0; j < small.size(); j++) {
            nums[i] = small.get(j);
            i++;
        }
        
        for (int j = 0; j < pivotCount; j++) {
            nums[i] = pivot;
            i++;
        }
        
        for (int j = 0; j < large.size(); j++) {
            nums[i] = large.get(j);
            i++;
        }
        
        return nums;
    }
   ```
   
   ## Optimized approach
   
   ```
      public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        
        int left = 0;
        int right = n - 1;
        int[] ans = new int[n];
        
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (nums[i] < pivot) ans[left++] = nums[i];
            if (nums[j] > pivot) ans[right--] = nums[j];
        }
        
        while (left <= right) ans[left++] = pivot;
        
        return ans;
    }
   ```
