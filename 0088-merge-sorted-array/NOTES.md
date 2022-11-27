## O(n) space 

![image](https://user-images.githubusercontent.com/77217430/204129100-d69ac12e-4685-4318-9b98-98be30474936.png)

```
 public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) res[k++] = nums1[i++];
            else res[k++] = nums2[j++];
        }
        
        while (i < m) res[k++] = nums1[i++];
        while (j < n) res[k++] = nums2[j++];
        
        for (int a = 0; a < m + n; a++) nums1[a] = res[a];
    
    }
}
```

## Constant space

- idea: iterating from backwards
- by doing so, it is guaranteed that once we start overwriting the first m values in nums1, we will have already written each into its new position.

![image](https://user-images.githubusercontent.com/77217430/204129123-c729c23b-efa1-4fc9-960e-c32fc593b9dd.png)

```
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
        
        while (i >= 0) nums1[k--] = nums1[i--];
        while (j >= 0) nums1[k--] = nums2[j--];
    }
```
