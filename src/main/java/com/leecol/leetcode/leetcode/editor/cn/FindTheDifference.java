//给定两个字符串 s 和 t，它们只包含小写字母。
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//
// 请找出在 t 中被添加的字母。
//
//
//
// 示例:
//
// 输入：
//s = "abcd"
//t = "abcde"
//
//输出：
//e
//
//解释：
//'e' 是那个被添加的字母。
//
// Related Topics 位运算 哈希表
// 👍 143 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

/**
 * 389,找不同
 */
public class FindTheDifference {
    public static void main(String[] args) {
        Solution solution = new FindTheDifference().new Solution();
        System.out.println(solution.findTheDifference("abc", "acbd"));
        System.out.println(solution.findTheDifference("aabbcc", "accabab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char findTheDifference(String s, String t) {
            if (s == null || s.length() <= 0) {
                return t.charAt(0);
            }

            if (t == null || t.length() <= 0) {
                return s.charAt(0);
            }

            int min = Math.min(s.length(), t.length());

            int m = s.charAt(0) ^ t.charAt(0);

            int i;

            for (i = 1; i < min; i++) {
                m = m ^ s.charAt(i) ^ t.charAt(i);
            }

            return i < s.length() ? (char) (m ^ s.charAt(i)) : (char) (m ^ t.charAt(i));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
