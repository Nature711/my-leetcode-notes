class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row0 = new ArrayList<>(), row1 = new ArrayList<>();
        row0.add(1);
        res.add(row0);

        for (int i = 1; i < numRows; i++) {
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            for (int j = 1; j < i; j++) {
                currRow.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
            }
            currRow.add(1);
            res.add(currRow);
        }
        
        return res;
    }
}