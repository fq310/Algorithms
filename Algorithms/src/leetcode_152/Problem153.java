package leetcode_152;

/**
 * Created by jason on 16-4-20.
 */
public class Problem153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0] > nums[1] ? nums[1] : nums[0];

        int left = 0, right = nums.length - 1, mid = (left + right) / 2;
        while (left < right) {
            if (nums[left] < nums[mid] && nums[mid] < nums[right]) {
                mid = left;
                break;
            }
            if (nums[mid] > nums[left] && nums[mid] > nums[right]) {
                left = mid;
                mid = (left + right) / 2;
            }
            if (nums[mid] < nums[left] && nums[mid] < nums[right]) {
                right = mid;
                mid = (left + right) / 2;
            }
            if (Math.abs(left - right) == 1) {
                mid = nums[left] < nums[right] ? left : right;
                break;
            }
        }

        return nums[mid];
    }

}
