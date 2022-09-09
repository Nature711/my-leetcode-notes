## Bit manipulation
- O(n) time, O(1) space
- Key idea:
  - a XOR a = 0
  - 0 XOR a = a
  - XOR is communitative
- (a XOR a) XOR (b XOR b) XOR ... XOR z  =  z <-- the single number
```
int result = 0;
    for (int i = 0; i<n; i++)
    {
		result ^=A[i];
    }
	return result;
```

## HashSet
- O(n) time and space
```
   public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num: nums) {
            if (set.contains(num)) set.remove(num);
            else set.add(num);
        }
            
        Iterator<Integer> iterator = set.iterator();
        
        return iterator.next();
    }
```
