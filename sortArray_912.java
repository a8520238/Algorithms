/**给你一个整数数组 nums，请你将该数组升序排列。 */
//手写快排
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int part = partition(nums, start, end);
            quickSort(nums, start, part - 1);
            quickSort(nums, part + 1, end);
        }
    }
    public int partition(int[] nums, int start, int end) {
        int contrast = nums[start];
        int index = start + 1;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < contrast) {
                swap(nums, i, index++);
            }
        }
        swap(nums, index - 1, start);
        return index - 1;
    }
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}