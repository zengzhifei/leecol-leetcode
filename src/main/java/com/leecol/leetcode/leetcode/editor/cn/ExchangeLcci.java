//配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
//
// 示例1:
//
//
// 输入：num = 2（或者0b10）
// 输出 1 (或者 0b01)
//
//
// 示例2:
//
//
// 输入：num = 3
// 输出：3
//
//
// 提示:
//
//
// num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
//
// Related Topics 位运算
// 👍 21 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

/**
 * 面试题 05.07,配对交换
 */
public class ExchangeLcci {
    public static void main(String[] args) {
        Solution solution = new ExchangeLcci().new Solution();
        System.out.println(solution.exchangeBits(1));
        System.out.println(solution.exchangeBits(2));
        System.out.println(solution.exchangeBits(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int exchangeBits(int num) {
            String s = Integer.toBinaryString(num);
            if (s.length() % 2 == 1) {
                s = 0 + s;
            }
            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i = i + 2) {
                chars[i] = (char) (chars[i] ^ chars[i + 1]);
                chars[i + 1] = (char) (chars[i] ^ chars[i + 1]);
                chars[i] = (char) (chars[i] ^ chars[i + 1]);
            }

            return Integer.valueOf(String.valueOf(chars), 2);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
