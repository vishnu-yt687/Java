class Solution {
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        
        mergesort(nums, indices, 0, n - 1);
        
        List<Integer> result = new ArrayList<>();
        for (int c : count) result.add(c);
        return result;
    }

    private void mergesort(int[] nums, int[] indices, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergesort(nums, indices, left, mid);
        mergesort(nums, indices, mid + 1, right);
        merge(nums, indices, left, mid, right);
    }

    private void merge(int[] nums, int[] indices, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (nums[indices[j]] < nums[indices[i]]) {
                temp[k++] = indices[j++];
                rightCount++; 
            } else {
                count[indices[i]] += rightCount; // Add all smaller elements found so far
                temp[k++] = indices[i++];
            }
        }

        while (i <= mid) {
            count[indices[i]] += rightCount;
            temp[k++] = indices[i++];
        }
        while (j <= right) {
            temp[k++] = indices[j++];
        }

        System.arraycopy(temp, 0, indices, left, temp.length);
    }
}