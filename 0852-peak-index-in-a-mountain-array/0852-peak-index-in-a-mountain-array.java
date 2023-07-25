class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high - 1) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) low = mid + 1;
            else high = mid - 1;
        }
        return (arr[low] < arr[high]) ? high : low;
    }
}