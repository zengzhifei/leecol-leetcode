//给定两个数组，编写一个函数来计算它们的交集。
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
//
//
// 示例 2:
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9]
//
//
//
// 说明：
//
//
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
// 我们可以不考虑输出结果的顺序。
//
//
// 进阶：
//
//
// 如果给定的数组已经排好序呢？你将如何优化你的算法？
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
//
// Related Topics 排序 哈希表 双指针 二分查找
// 👍 361 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 350,两个数组的交集 II
 */
public class IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
        System.out.println(Arrays.toString(solution.intersect(new int[] {1, 2, 2, 1}, new int[] {2, 2})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
                return new int[0];
            }

            int[] mins = nums1.length <= nums2.length ? nums1 : nums2;
            int[] maxs = nums1.length > nums2.length ? nums1 : nums2;

            Arrays.sort(mins);
            Arrays.sort(maxs);

            Map<Integer, Integer> map = new HashMap<>();

            int max = mins[0];

            for (Integer integer : mins) {
                map.compute(integer, (k, v) -> (v == null) ? 1 : v + 1);
                max = integer;
            }

            int[] ret = new int[maxs.length];
            int j = 0;
            for (Integer integer : maxs) {
                if (integer > max) {
                    break;
                }

                if (map.containsKey(integer) && map.get(integer) > 0) {
                    ret[j++] = integer;
                    map.computeIfPresent(integer, (k, v) -> v - 1);
                }
            }

            return Arrays.copyOfRange(ret, 0, j);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
