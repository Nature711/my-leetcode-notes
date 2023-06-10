class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int nLeft = index, nRight = n - index - 1;
        long left = 1, right = maxSum;
        while (left < right) {
            long max = (left + right + 1) / 2;
            long sumLeft = 0, sumRight = 0;
            if (nLeft > 0) {
                if (nLeft < max) {
                    sumLeft = nLeft * (2 * max - nLeft - 1) / 2;
                } else {
                    sumLeft = (max - 1) * max / 2;
                    long diff = nLeft - max + 1;
                    sumLeft += diff;
                }
            }
            if (nRight > 0) {
                if (nRight < max) {
                   sumRight = nRight * (2 * max - nRight - 1) / 2;
                } else {
                    sumRight = (max - 1) * max / 2;
                    long diff = nRight - max + 1;
                    sumRight += diff;
                }
            }
            // System.out.println("sumLeft " + sumLeft + " sumRight " + sumRight + " MAX " + max);
            // System.out.println(sumLeft + sumRight + max);
            if (sumLeft + sumRight + max <= maxSum) left = max;
            else right = max - 1;
        }
        return (int) left;
    }

}