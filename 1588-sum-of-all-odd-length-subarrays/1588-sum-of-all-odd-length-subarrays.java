class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0,n=arr.length,i;
        for(i =0;i<n;i++)
		{
            int contribution = (int)Math.ceil((i+1)*(n-i)/2.0);
            ans+=(contribution*arr[i]);
        }
        return ans;
    }
}