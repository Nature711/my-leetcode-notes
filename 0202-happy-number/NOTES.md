## iterative
```
public boolean isHappy(int n) {
        int num = n;
        HashSet<Integer> seen = new HashSet<>();
        while (true) {
            int res = 0;
            while (num > 0) {
                res += (int) Math.pow(num % 10, 2);
                num /= 10;
            }
            
            if (res == 1) return true;
            if (seen.contains(res)) return false;
            seen.add(res);
            num = res;
        }
        
    }
```

## hardcoding recursion
```
public boolean isHappy(int n) {
        if (n == 7 || n == 1) return true;
        if (n < 10) return false;
        int res = 0;
        while (n > 0) {
            res += (int) Math.pow(n % 10, 2);
            n /= 10;
        }
        if (res == 1) return true;
        return isHappy(res);
    }
```
