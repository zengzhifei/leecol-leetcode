//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//
// 示例 1：
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true
//
//
// 示例 2：
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
//
//
// 说明：
//
//
// 0 <= len(s1) <= 100
// 0 <= len(s2) <= 100
//
// Related Topics 数组 字符串
// 👍 12 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 01.02,判定是否互为字符重排
 */
public class CheckPermutationLcci {
    public static void main(String[] args) {
        Solution solution = new CheckPermutationLcci().new Solution();
        System.out.println(solution.CheckPermutation("abc", "bca"));
        System.out.println(solution.CheckPermutation("abc", "bad"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            if (s1 == null || s2 == null || (s1.length() == 0 && s2.length() == 0)) {
                return true;
            }

            if (s1.length() != s2.length()) {
                return false;
            }

            List<Character> characters = new ArrayList<>();
            for (Character character : s2.toCharArray()) {
                characters.add(character);
            }

            for (Character character : s1.toCharArray()) {
                if (characters.contains(character)) {
                    characters.remove(character);
                }
            }

            return characters.isEmpty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
