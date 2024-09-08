class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int curr1 = 0, curr2 = 0;
        int m = firstList.length, n = secondList.length;
        List<Integer> res = new ArrayList<>();
        while (curr1 < m && curr2 < n) {
            int[] overlap = getOverlap(firstList[curr1], secondList[curr2]);
            if (overlap[0] <= overlap[1]) {
                res.add(overlap[0]);
                res.add(overlap[1]);
            }
            if (firstList[curr1][1] < secondList[curr2][1]) curr1++;
            else curr2++;
        }
        int size = res.size() / 2;
        int[][] finalRes = new int[size][2];
        int i = 0;
        for (int j = 0; j < size; j++) {
            finalRes[j][0] = res.get(i++);
            finalRes[j][1] = res.get(i++);
        }
        return finalRes;
    }
    
    int[] getOverlap(int[] i1, int[] i2) {
        int[] res = new int[2];
        res[0] = Math.max(i1[0], i2[0]);
        res[1] = Math.min(i1[1], i2[1]);
        return res;
    }
}