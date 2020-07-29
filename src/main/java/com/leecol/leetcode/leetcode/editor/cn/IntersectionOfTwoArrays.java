//给定两个数组，编写一个函数来计算它们的交集。
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
//
//
// 示例 2：
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//
//
//
// 说明：
//
//
// 输出结果中的每个元素一定是唯一的。
// 我们可以不考虑输出结果的顺序。
//
// Related Topics 排序 哈希表 双指针 二分查找
// 👍 211 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 349,两个数组的交集
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        System.out.println(Arrays.toString(solution.intersection(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
                return new int[0];
            }

            int[] mins = nums1.length <= nums2.length ? nums1 : nums2;
            int[] maxs = nums1.length > nums2.length ? nums1 : nums2;

            Arrays.sort(mins);
            Arrays.sort(maxs);

            Map<Integer, Boolean> map = new HashMap<>();

            int max = mins[0];

            for (Integer integer : mins) {
                map.put(integer, true);
                max = integer;
            }

            int[] ret = new int[mins.length];
            int j = 0;
            for (Integer integer : maxs) {
                if (integer > max) {
                    break;
                }

                if (map.containsKey(integer) && (j == 0 || ret[j - 1] != integer)) {
                    ret[j++] = integer;
                }
            }

            return Arrays.copyOfRange(ret, 0, j);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
