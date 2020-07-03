//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串

package com.leecol.leetcode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20,有效的括号
 */
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid( "([)]"));
        System.out.println(solution.isValid( "{[]}"));
        System.out.println(solution.isValid( "{[()]}"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> map = new HashMap<Character, Character>(3) {
                {
                    put(')', '(');
                    put('}', '{');
                    put(']', '[');
                }
            };

            Stack<Character> stack = new Stack<>();

            char[] chars = s.toCharArray();
            for (char c : chars) {
                Character left = map.get(c);
                if (!stack.isEmpty() && stack.lastElement().equals(left)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            return stack.isEmpty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
