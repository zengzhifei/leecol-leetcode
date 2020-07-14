//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串
// 👍 246 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

/**
 * 125,验证回文串
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome("aa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }

            char[] chars = s.toCharArray();

            int i = 0, j = chars.length - 1;

            while (i != j && j > i) {
                if (!Character.isLetter(chars[i]) && !Character.isDigit(chars[i])) {
                    i++;
                    continue;
                }

                if (!Character.isLetter(chars[j]) && !Character.isDigit(chars[j])) {
                    j--;
                    continue;
                }

                if (String.valueOf(chars[i]).equalsIgnoreCase(String.valueOf(chars[j]))) {
                    i++;
                    j--;
                    continue;
                }

                return false;
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
