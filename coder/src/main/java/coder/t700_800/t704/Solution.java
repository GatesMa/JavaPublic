package coder.t700_800.t704;

/**
 * 找一个数： left = 0 right = length - 1， left <= right, left = mid + 1, right = mid - 1  搜索区间的概念
 * 左侧边界： left = 0 right = length left < right, left = mid + 1, right = mid， return left / right
 * 右侧边界： left = 0 right = length left < right, left = mid + 1, right = mid， return left - 1 / right - 1
 */
class Solution {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return -1;
    }
}