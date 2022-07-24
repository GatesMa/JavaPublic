package coder.t1_100.t1;

import java.util.Arrays;

@Deprecated
class Solution2 {

    public int[] twoSum(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        Arrays.sort(nums);

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{left, right};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}