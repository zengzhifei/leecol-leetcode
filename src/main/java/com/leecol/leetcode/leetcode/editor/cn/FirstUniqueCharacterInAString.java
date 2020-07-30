//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//
//
// 示例：
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
//
//
//
//
// 提示：你可以假定该字符串只包含小写字母。
// Related Topics 哈希表 字符串
// 👍 242 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 387,字符串中的第一个唯一字符
 */
public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
        System.out.println(solution.firstUniqChar("leetcode"));
        System.out.println(solution.firstUniqChar("loveleetcode"));
        System.out.println(solution.firstUniqChar("aadadaad"));
        System.out.println(solution.firstUniqChar("dddccdbba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> maps = new HashMap<>();
            char[] chars = s.toCharArray();
            Map<Character, Integer> ret = new LinkedHashMap<>();

            for (int i = 0; i < chars.length; i++) {
                maps.compute(chars[i], (k, v) -> (v == null) ? 1 : v + 1);
                if (maps.get(chars[i]) == 1) {
                    ret.put(chars[i], i);
                } else {
                    ret.remove(chars[i]);
                }
            }

            return ret.entrySet().stream().findFirst().map(Map.Entry::getValue).orElse(-1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
