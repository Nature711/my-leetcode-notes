## Use cases
- problem: every time we want to find the min / max element from a set of numbers, but are modifying the set on the fly
- sorting won't solve the problem since it's just done once at the start; the modification on the fly would break the sorted sequence; the only fix is to sort every time whichi takes O(NlogN)
- solution: min / max heap -- find min / min in O(1) since we just pop from top; for any modification the rebalance can be achieved in O(logN)
