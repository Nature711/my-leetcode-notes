## Single number I
- All elements appear exactly twice except for one element which appears exactly once. Find that element.
![image](https://user-images.githubusercontent.com/77217430/211230455-b514a4ff-2b26-4efc-a469-aba1a177237d.png)
```
  public int singleNumber(int[] nums) {
    int a = 0;
    for (int i : nums) {
      a ^= i;
    }
    return a;
  }
```

## Single number II
- [explanation](https://lenchen.medium.com/leetcode-137-single-number-ii-31af98b0f462)
- All elements appear exactly three times except for one element which appears exactly once. Find that element.
![image](https://user-images.githubusercontent.com/77217430/211230685-8fc2e47b-213f-4f4b-bda6-7c284c3cf657.png)
![image](https://user-images.githubusercontent.com/77217430/211230711-a073ab35-6b0f-47ab-b1d7-beb69af4622f.png)
```
public int singleNumber(int[] nums) {
    int seenOnce = 0, seenTwice = 0;

    for (int num : nums) {
      // first appearence: 
      // add num to seen_once 
      // don't add to seen_twice because of presence in seen_once

      // second appearance: 
      // remove num from seen_once 
      // add num to seen_twice

      // third appearance: 
      // don't add to seen_once because of presence in seen_twice
      // remove num from seen_twice
      seenOnce = ~seenTwice & (seenOnce ^ num);
      seenTwice = ~seenOnce & (seenTwice ^ num);
    }

    return seenOnce;
  }
```
