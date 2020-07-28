//删除链表中等于给定值 val 的所有节点。
//
// 示例:
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
//
// Related Topics 链表
// 👍 411 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

import com.leecol.leetcode.leetcode.editor.cn.tool.ListNode;

/**
 * 203,移除链表元素
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
        ListNode listNode = solution.removeElements(ListNode.build(1, 2, 6, 3, 4, 5, 6), 6);
        ListNode.print(listNode);
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
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }

            ListNode pointer = head;

            while (pointer.next != null) {
                if (pointer.next.val == val) {
                    pointer.next = pointer.next.next;
                } else {
                    pointer = pointer.next;
                }
            }

            return head.val == val ? head.next : head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
