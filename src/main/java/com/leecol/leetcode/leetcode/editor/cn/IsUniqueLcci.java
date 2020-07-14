//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
//
// 示例 1：
//
// 输入: s = "leetcode"
//输出: false
//
//
// 示例 2：
//
// 输入: s = "abc"
//输出: true
//
//
// 限制：
//
// 0 <= len(s) <= 100
// 如果你不使用额外的数据结构，会很加分。
//
// Related Topics 数组
// 👍 41 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

/**
 * 面试题 01.01,判定字符是否唯一
 */
public class IsUniqueLcci {
    public static void main(String[] args) {
        Solution solution = new IsUniqueLcci().new Solution();
        System.out.println(solution.isUnique("leetcode"));
        System.out.println(solution.isUnique("abc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUnique(String astr) {
            if (astr == null || astr.length() <= 1) {
                return true;
            }

            char[] chars = astr.toCharArray();

            int i = 0;
            while (i < chars.length - 1) {
                int j = i + 1;
                while (j < chars.length) {
                    if (chars[i] == chars[j]) {
                        return false;
                    }
                    j++;
                }
                i++;
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
