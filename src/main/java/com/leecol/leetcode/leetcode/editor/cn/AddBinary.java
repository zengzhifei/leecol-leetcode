//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。
//
//
//
// 示例 1:
//
// 输入: a = "11", b = "1"
//输出: "100"
//
// 示例 2:
//
// 输入: a = "1010", b = "1011"
//输出: "10101"
//
//
//
// 提示：
//
//
// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4
// 字符串如果不是 "0" ，就都不含前导零。
//
// Related Topics 数学 字符串

package com.leecol.leetcode.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 67,二进制求和
 */
public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        System.out.println(solution.addBinary("11", "1"));
        System.out.println(solution.addBinary("1010", "1011"));
        System.out.println(solution.addBinary("0", "0"));
        System.out.println(solution.addBinary("1111", "1111"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int i = Math.max(a.length(), b.length());
            int offset = Math.abs(a.length() - b.length());
            char[] chars = new char[i + 1];
            int carry = 0;
            while (--i >= 0) {
                int one, two;
                if (a.length() >= b.length()) {
                    one = a.charAt(i) - '0';
                    two = i - offset >= 0 ? b.charAt(i - offset) - '0' : 0;
                } else {
                    one = i - offset >= 0 ? a.charAt(i - offset) - '0' : 0;
                    two = b.charAt(i) - '0';
                }
                char val = (one + two + carry) == 2 || (one + two + carry) == 0 ? '0' : '1';
                carry = (one + two + carry) >= 2 ? 1 : 0;
                chars[i + 1] = val;
            }
            chars[0] = carry == 1 ? '1' : '0';
            return carry == 1 ? String.valueOf(chars) : String.valueOf(Arrays.copyOfRange(chars, 1, chars.length));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
