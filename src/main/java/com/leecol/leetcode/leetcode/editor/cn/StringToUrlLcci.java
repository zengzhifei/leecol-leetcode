//URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，
//请使用字符数组实现，以便直接在数组上操作。）
//
// 示例1:
//
//  输入："Mr John Smith    ", 13
// 输出："Mr%20John%20Smith"
//
//
// 示例2:
//
//  输入："               ", 5
// 输出："%20%20%20%20%20"
//
//
// 提示：
//
//
// 字符串长度在[0, 500000]范围内。
//
// Related Topics 字符串
// 👍 12 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 面试题 01.03,URL化
 */
public class StringToUrlLcci {
    public static void main(String[] args) {
        Solution solution = new StringToUrlLcci().new Solution();
        System.out.println(solution.replaceSpaces("Mr John Smith    ", 13));
        System.out.println(solution.replaceSpaces("               ", 5));
        System.out.println(solution.replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpaces(String s, int length) {
            if (s == null || s.length() == 0) {
                return null;
            }

            char[] chars = s.toCharArray();

            int replace = 0;

            int i = 0;
            //            while (i < (length + 2 * replace)) {
            //                if (chars[i] == ' ') {
            //                    System.arraycopy(chars, i + 1, chars, i + 3, length + 2 * replace - i - 1);
            //                    chars[i] = '%';
            //                    chars[i + 1] = '2';
            //                    chars[i + 2] = '0';
            //                    i = i + 3;
            //                    replace++;
            //                    continue;
            //                }
            //
            //                i++;
            //            }
            //
            //            char[] ret = Arrays.copyOfRange(chars, 0, length + 2 * replace);
            //
            //            return String.valueOf(ret);

            StringBuilder sb = new StringBuilder();
            while (i < length) {
                if (chars[i] == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(chars[i]);
                }
                i++;
            }
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
