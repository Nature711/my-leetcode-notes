## Floyd's Tortoise and Hare (Cycle Detection)

![image](https://user-images.githubusercontent.com/77217430/189521681-eceeb7b4-2177-4ee7-9c24-91c99b91d2fa.png)

```
  public int findDuplicate(int[] nums) {
        
        int fast = nums[0];
        int slow = nums[0];
        
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }
        
        int ptr = nums[0];
        
        while (ptr != slow) {
            ptr = nums[ptr];
            slow = nums[slow];
        }
        
        return ptr;
    }
```


## Sorting
```
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }
        return nums[0];
    }
```

## Negative Marking
```
    public int findDuplicate(int[] nums) {
        
        int i = nums[0];
        while (true) {
            if (nums[i] < 0) return i;
            nums[i] = - nums[i];
            i = Math.abs(nums[i]);
        }
        
    }
```
