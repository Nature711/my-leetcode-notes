## DP
- sort pairs by first index
- same idea as LIS
```
  public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> p1[0] - p2[0]);
        
        int[] dp = new int[pairs.length];
        
        int res = 0;
        
        for (int i = 0; i < pairs.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(dp[i], res);
        }
        
        return res;
    }
```
## Greedy
- Problem: Given an array of n pairs [p1, p2, ... pn], find the longest chain length
- Optimal solution: the choice of pair chain that has the maximum length
- Optimal substructure
  - Suppose S is any optimal solution with chain length k, and S contains pair i
  - Claim: T = S - {i} is optimal for the subproblem with the i-th pair removed and chain length k - 1 
  - Cut & paste proof: If T is optimal for the subproblem and has chain length longer than k - 1, then T U {i} would produce a chain length longer than k. Contradiction.
- Greedy-choice property
  - Suppose the i-th pair has the minimum second index
  - Claim: There exists an optimal solution that contains pair i
  - Proof: Suppose there is an optimal solution that does not contain pair i. Then, replace the last pair in S with pair i. The chain length does not decrease. So new chain is optimal and contains pair i.

 1 [(1,2), (3,4), (5,6). (7,8)]

 2 [(1,2), (4,5), (3,6). (6,7)]

(case1) When pairA[1] < pairB[0], it's obvious that we should append pairA first.

(case2) When pairA[1] >= pairB[0], we have to choose carefully, because that means:
     either we only append pairA to the chain,
     or we only append pairB to the chain.
 Append either pairA or pairB will increment the length of the chain by 1.
 However: (note: cur is the tail of the chain)
     appending pairA will have cur = pairA[1],
     appending pairB will have cur = pairB[1].
     And pairA[1] < pairB[1]
 Apparently, we shall append pairA first because that way we expose a smaller tail which has a better opportunity to append more future pairs.

