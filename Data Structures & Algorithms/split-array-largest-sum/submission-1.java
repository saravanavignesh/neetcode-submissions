class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        for (int n : nums) {
            left = Math.max(left, n); // min possible largest sum
            right += n; // max possible largest sum
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1, sum = 0;
        for (int n : nums) {
            if (sum + n > maxSum) {
                count++;
                sum = n;
            } else {
                sum += n;
            }
        }
        return count <= k;
    }
}