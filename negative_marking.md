## [Find All Numbers Disappeared in an Array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
```
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr = Math.abs(nums[i]) % n;
            if (nums[curr] > 0) nums[curr] = - nums[curr];
        }
        List<Integer> res = new ArrayList<>();
        if (nums[0]  > 0) res.add(n);
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) res.add(i);
        }
        return res;
    }
  ```
  
  ## [Missing Number](https://leetcode.com/problems/missing-number/)
  ```
  public int missingNumber(int[] nums) {
        
        int n = nums.length;
        int num = n + 1;
        
        for (int i = 0; i < n; i++) {
            if (Math.abs(nums[i]) == n) continue;
            else if (nums[Math.abs(nums[i])] == 0) num = Math.abs(nums[i]);
            else nums[Math.abs(nums[i])] = - nums[Math.abs(nums[i])];
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (num != i) return i;
            }
            if (nums[i] > 0) return i;
        }
        
        return n;
    }
 ```
 
 ## [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/)
 ```
  public int findDuplicate(int[] nums) {
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur] < 0) {
                duplicate = cur;
                break;
            }
            nums[cur] *= -1;
        }
        
        // Restore numbers
        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.abs(nums[i]);

        return duplicate;
    }
 ```
