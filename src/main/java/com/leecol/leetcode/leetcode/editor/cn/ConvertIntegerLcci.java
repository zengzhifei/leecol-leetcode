//整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
//
// 示例1:
//
//
// 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
// 输出：2
//
//
// 示例2:
//
//
// 输入：A = 1，B = 2
// 输出：2
//
//
// 提示:
//
//
// A，B范围在[-2147483648, 2147483647]之间
//
// Related Topics 位运算
// 👍 8 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

/**
 * 面试题 05.06,整数转换
 */
public class ConvertIntegerLcci {
    public static void main(String[] args) {
        Solution solution = new ConvertIntegerLcci().new Solution();
        System.out.println(solution.convertInteger(1, 2));
        System.out.println(solution.convertInteger(29, 15));
        System.out.println(solution.convertInteger(1527700032, 1678530761));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int convertInteger(int a, int b) {
            int num = 0;

            if (a == b) {
                return num;
            }

            char[] c = Integer.toBinaryString(a ^ b).toCharArray();

            for (Character character : c) {
                if (character == '1') {
                    num++;
                }
            }

            return num;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
