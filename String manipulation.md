### Tools 
- [Regexr online tester](https://regexr.com/)
- [Regex cheatsheat](https://www.rexegg.com/regex-quickstart.html)

### Split sentence into word array

- ```String.split(regex, limit)```
- regex: a delimiting regular expression
- limit – the resulting threshold
  - limit > 0 – the pattern will be applied at most limit-1 times, the resulting array’s length will not be more than n, and the resulting array’s last entry will contain all input beyond the last matched pattern.
  - limit < 0 – the pattern will be applied as many times as possible, and the resulting array can be of any size.
  - limit = 0 – the pattern will be applied as many times as possible, the resulting array can be of any size, and trailing empty strings will be discarded.
```
String s = "This is a sentence";
String words = s.split("\s+");
words: ["This", "is", "a", "sentence"]
```

### Remove leading and trailing spaces
- ```String.trim()```
```
String s = " This is a sentence ";
String s1 = s.trim();
s1: "This is a sentence"
```
- ```String.replaceAll("^\\s+|\\s+$", "")```
- \s -- matches any whitespaces
- + -- 1 or more occurrences
- \s+ -- matches any number of consecutive whitespaces
- ^ -- matches the start of string
- $ -- matches the end of string
- ^\s+ -- matches any number of leading whitespaces
- $\s+ -- matches any number of trailing whitespaces
- | -- logical OR
