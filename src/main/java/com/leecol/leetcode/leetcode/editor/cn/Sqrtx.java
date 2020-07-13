//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
// 示例 1:
//
// 输入: 4
//输出: 2
//
//
// 示例 2:
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842...,
//     由于返回类型是整数，小数部分将被舍去。
//
// Related Topics 数学 二分查找

package com.leecol.leetcode.leetcode.editor.cn;

/**
 * 69,x 的平方根
 */
public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        System.out.println(solution.mySqrt(2147395599));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            if (x == 1) {
                return 1;
            }

            return sqrt(x / 2, x, x);
        }

        private int sqrt(int start, int end, int target) {
            if (target / (double) start == (double) start || target / (double) end == (double) end ||
                    start == end) {
                return start;
            }

            if (target / (double) start < (double) start) {
                return sqrt(1, start, target);
            } else if (start == end - 1) {
                return start;
            } else {
                return sqrt(start + (end - start) / 2, end, target);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
