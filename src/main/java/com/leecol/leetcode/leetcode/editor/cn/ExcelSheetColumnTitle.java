//给定一个正整数，返回它在 Excel 表中相对应的列名称。
//
// 例如，
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB
//    ...
//
//
// 示例 1:
//
// 输入: 1
//输出: "A"
//
//
// 示例 2:
//
// 输入: 28
//输出: "AB"
//
//
// 示例 3:
//
// 输入: 701
//输出: "ZY"
//
// Related Topics 数学
// 👍 238 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

/**
 * 168,Excel表列名称
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnTitle().new Solution();
        System.out.println(solution.convertToTitle(1));
        System.out.println(solution.convertToTitle(26));
        System.out.println(solution.convertToTitle(27));
        System.out.println(solution.convertToTitle(28));
        System.out.println(solution.convertToTitle(701));
        System.out.println(solution.convertToTitle(711));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int n) {
            StringBuilder sb = new StringBuilder();
            while (n > 0) {
                int p = n % 26;
                n = n / 26;
                if (p > 0) {
                    sb.append((char) (p + 64));
                } else if (n <= 26){
                    sb.append('A');
                }

            }
            return sb.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
