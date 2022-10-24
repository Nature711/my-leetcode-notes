## [Broken Calculator](https://leetcode.com/problems/broken-calculator/)

- At each step, a calculator can only multiply the number on display by 2, or subtract 1 from the number on display. Find min steps required to get from start to target.

- Multiplication may result in integer overflow --> consider working backwards (i.e., target to start)
  - choice 1: multiply start by 2 <--> divide target by 2
  - choice 2: decrement start  by 1 <--> increment target by 1

- choice 1 is possible only if target is divisible by 2
  - moreover, if this is the case, then we shouldn't try choice 2 since it will only make us further away from start -- no point of doing so
- if target is not divisible by 2, then we only have choice 2

--> each step we have exactly 1 choice!

- base case: target < start -- we're dividing too much! the only way to get back to start is by incrementing; how much times need to increment is just (start - target)

```
    public int brokenCalc(int startValue, int target) {
    
        if (target <= startValue) return startValue - target; //base case
        
        if (target % 2 == 0) return 1 + brokenCalc(startValue, target / 2); //choice 1
        
        else return 1 + brokenCalc(startValue, target + 1); //choice 2
    }
```
