//不使用运算符 + 和 - ，计算两整数 a 、b 之和。
//
// 示例 1:
//
// 输入: a = 1, b = 2
//输出: 3
//
//
// 示例 2:
//
// 输入: a = -2, b = 3
//输出: 1
// Related Topics 位运算
// 👍 289 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

/**
 * 371,两整数之和
 */
public class SumOfTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new SumOfTwoIntegers().new Solution();
        System.out.println(solution.getSum(3,7));
        System.out.println(solution.getSum(2,5));
        System.out.println(solution.getSum(6,2));
        System.out.println(solution.getSum(7,34));
        System.out.println(solution.getSum(-7,34));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getSum(int a, int b) {
            return ((a & b) << 1) + (a ^ b);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
