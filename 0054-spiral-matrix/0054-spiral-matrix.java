class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int count = m * n;
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        
        while (res.size() < count) {
            
            if (top == bottom) {
                while (left <= right) res.add(matrix[top][left++]);
                break;
            }
            
            if (left == right) {
                while (top <= bottom) res.add(matrix[top++][left]);
                break;
            }
            
            j = left;
            while (res.size() < count && j < right) {
                res.add(matrix[top][j]);
                j++;
            }
           
            i = top;
            while (res.size() < count && i < bottom) {
                res.add(matrix[i][right]);
                i++;
            }
               
            j = right;
            while (res.size() < count && j > left) {
                res.add(matrix[bottom][j]);
                j--;
            }
              
            i = bottom;
            while (res.size() < count && i > top) {
                res.add(matrix[i][left]);
                i--;
            }
             
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}