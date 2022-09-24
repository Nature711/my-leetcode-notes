class Solution {
    public int findKthPositive(int[] arr, int k) {
        int curr = 1;
        int i = 0;
        int max = arr[arr.length - 1];
        
        while (i < arr.length) {
            while (arr[i] != curr) {
                k--;
                if (k == 0) return curr;
                curr++;
            }
            curr++;
            i++;
        }
        return curr + k - 1;
    }
}