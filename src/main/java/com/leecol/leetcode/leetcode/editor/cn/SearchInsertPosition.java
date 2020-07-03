//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
//输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
//输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
//
// Related Topics 数组 二分查找

package com.leecol.leetcode.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 35,搜索插入位置
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 0));
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            return find(nums, target, 0);
        }

        private int find(int[] nums, int target, int step) {
            if (nums == null || nums.length == 0) {
                return step;
            }

            int index = nums.length / 2;

            if (nums[index] > target) {
                if (nums.length == 1) {
                    return index + step;
                }
                return find(Arrays.copyOfRange(nums, 0, index), target, step);
            } else if (nums[index] < target) {
                if (nums.length == 1) {
                    return index + step + 1;
                }
                return find(Arrays.copyOfRange(nums, index + 1, nums.length), target, step + index + 1);
            } else {
                return index + step;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
