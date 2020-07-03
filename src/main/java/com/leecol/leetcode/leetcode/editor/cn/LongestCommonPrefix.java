//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串

package com.leecol.leetcode.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 14,最长公共前缀
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        System.out.println(solution.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[] {"aa", "a", "a"}));
        System.out.println(solution.longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length <= 0) {
                return "";
            }

            String ret = strs[0];
            for (int i = 1; i < strs.length; i++) {
                int j = 0;
                for (; j < ret.length() && j < strs[i].length(); j++) {
                    if (ret.charAt(j) != strs[i].charAt(j)) {
                        break;
                    }
                }
                ret = ret.substring(0, j);
            }

            return ret;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
