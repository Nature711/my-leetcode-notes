class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0) return false;
        
        List<Integer> xList = new ArrayList<>();
        while (x > 0) {
            int curr = x % 10;
            xList.add(curr);
            x -= curr;
            x /= 10;
        }

    
        int low = 0, high = xList.size() - 1;
        while (low < high) {
            if (xList.get(low) != xList.get(high)) return false;
            low++;
            high--;
        }
        return true;
    }
}