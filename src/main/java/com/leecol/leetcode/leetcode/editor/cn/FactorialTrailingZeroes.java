//给定一个整数 n，返回 n! 结果尾数中零的数量。
//
// 示例 1:
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。
//
// 示例 2:
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零.
//
// 说明: 你算法的时间复杂度应为 O(log n) 。
// Related Topics 数学
// 👍 311 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

/**
 * 172,阶乘后的零
 */
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new FactorialTrailingZeroes().new Solution();
        System.out.println(solution.trailingZeroes(3));
        System.out.println(solution.trailingZeroes(5));
        System.out.println(solution.trailingZeroes(7));
        System.out.println(solution.trailingZeroes(13));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes(int n) {
            int count = 0;
            while (n > 0) {
                count += n / 5;
                n = n / 5;
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
