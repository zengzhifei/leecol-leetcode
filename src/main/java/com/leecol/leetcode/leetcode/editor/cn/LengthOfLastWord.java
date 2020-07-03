//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
//
// 如果不存在最后一个单词，请返回 0 。
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
//
//
//
// 示例:
//
// 输入: "Hello World"
//输出: 5
//
// Related Topics 字符串

package com.leecol.leetcode.leetcode.editor.cn;

/**
 * 58,最后一个单词的长度
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord().new Solution();
        System.out.println(solution.lengthOfLastWord("Hello World"));
        System.out.println(solution.lengthOfLastWord("Hello Wor "));
        System.out.println(solution.lengthOfLastWord("Hello World123"));
        System.out.println(solution.lengthOfLastWord("Hello World123 ni "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            if (s == null || s.length() <= 0) {
                return 0;
            }

            char[] chars = s.toCharArray();
            int size = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                if (size > 0 && chars[i] == ' ') {
                    break;
                }

                if (size == 0 && chars[i] == ' ') {
                    continue;
                }

                size += 1;
            }

            return size;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
