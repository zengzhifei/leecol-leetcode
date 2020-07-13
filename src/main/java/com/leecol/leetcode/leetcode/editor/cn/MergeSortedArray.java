//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
//
//
// 说明:
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
//
//
// 示例:
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
// Related Topics 数组 双指针
// 👍 557 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 88,合并两个有序数组
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] nums1 = new int[] {1, 2, 3, 4,0, 0, 0};
        int[] nums2 = new int[] {2, 5, 6};
        solution.merge(nums1, 4, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = 0, j = 0;
            int[] tmp = new int[m + n];
            while (i < m || j < n) {
                if (i >= m) {
                    tmp[i + j] = nums2[j];
                    j++;
                } else if (j >= n) {
                    tmp[i + j] = nums1[i];
                    i++;
                } else if (nums1[i] < nums2[j]) {
                    tmp[i + j] = nums1[i];
                    i++;
                } else {
                    tmp[i + j] = nums2[j];
                    j++;
                }
            }

            System.arraycopy(tmp, 0, nums1, 0, m + n);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
