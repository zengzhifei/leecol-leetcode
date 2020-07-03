//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window

package com.leecol.leetcode.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 3,无重复字符的最长子串
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        int size = solution.lengthOfLongestSubstring("pwwkew");
        System.out.println(size);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Queue<Character> queue = new LinkedList<>();
            int max = 0;
            for (char c : s.toCharArray()) {
                while (queue.contains(c)) {
                    queue.poll();
                }
                queue.add(c);
                max = Math.max(max, queue.size());
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
