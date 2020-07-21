//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
//
// 示例1:
//
//
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
//
//
// 示例2:
//
//
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
//
//
// 提示：
//
//
// 链表长度在[0, 20000]范围内。
// 链表元素在[0, 20000]范围内。
//
//
// 进阶：
//
// 如果不得使用临时缓冲区，该怎么解决？
// Related Topics 链表
// 👍 52 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

import com.leecol.leetcode.leetcode.editor.cn.tool.ListNode;

/**
 * 面试题 02.01,移除重复节点
 */
public class RemoveDuplicateNodeLcci {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateNodeLcci().new Solution();
        ListNode listNode = ListNode.build(1, 2, 3, 3, 2, 1);
        ListNode ret = solution.removeDuplicateNodes(listNode);
        ListNode.print(ret);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode removeDuplicateNodes(ListNode head) {
            Set<Integer> set = new HashSet<>();
            ListNode pre = head;
            ListNode ret = pre;
            while (head != null) {
                if (set.contains(head.val)) {
                    if (head.next == null) {
                        pre.next = null;
                    }
                } else {
                    set.add(head.val);
                    if (pre != head) {
                        pre.next = head;
                        pre = pre.next;
                    }
                }
                head = head.next;
            }
            return ret;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
