class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (numRows == 1) {
            List<Integer> baseCase = new ArrayList<>();
            baseCase.add(1);
            res.add(baseCase);
            return res;
        }
        
        List<List<Integer>> subprob = generate(numRows - 1);
        List<Integer> last = subprob.get(numRows - 2);
        
        List<Integer> curr = new ArrayList<>();
        curr.add(1);
        for (int i = 0; i < numRows - 2; i++) {
            curr.add(last.get(i) + last.get(i + 1));
        }
        curr.add(1);
        subprob.add(curr);
        return subprob;
    }
}