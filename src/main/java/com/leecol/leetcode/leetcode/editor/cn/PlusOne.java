//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
// 示例 1:
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
//
//
// 示例 2:
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
//
// Related Topics 数组

package com.leecol.leetcode.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 66,加一
 */
public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        int[] ret = solution.plusOne(new int[]{4,3,2,1});
        System.out.println(Arrays.toString(ret));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            if (digits == null || digits.length == 0) {
                return new int[] {1};
            }

            int[] ret = new int[digits.length + 1];

            int carry = 0;
            for (int i = digits.length - 1; i >= 0; i--) {
                int plus = i == digits.length - 1 ? 1 : 0;
                int val = digits[i] + plus + carry;
                carry = val >= 10 ? 1 : 0;
                ret[i + 1] = val % 10;
            }

            ret[0] = carry;
            return ret[0] == 0 ? Arrays.copyOfRange(ret, 1, ret.length) : ret;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
