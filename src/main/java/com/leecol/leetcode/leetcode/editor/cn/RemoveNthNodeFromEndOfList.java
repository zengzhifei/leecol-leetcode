//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例：
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//
//
// 说明：
//
// 给定的 n 保证是有效的。
//
// 进阶：
//
// 你能尝试使用一趟扫描实现吗？
// Related Topics 链表 双指针
// 👍 897 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

import com.leecol.leetcode.leetcode.editor.cn.tool.ListNode;

/**
 * 19,删除链表的倒数第N个节点
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode listNode = ListNode.build(1, 2, 3, 4, 5);
        ListNode.print(solution.removeNthFromEnd(listNode, 5));
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) {
                return null;
            }

            if (n <= 0) {
                return head;
            }

            ListNode prev = head;
            ListNode listNode = prev;

            ListNode slow = head;
            ListNode fast = head;

            while (n-- > 0) {
                fast = fast.next;
            }

            while (fast != null) {
                if (slow != head) {
                    prev = slow;
                }

                fast = fast.next;
                slow = slow.next;
            }

            if (prev == slow) {
                prev = slow.next;
                listNode = prev;
            } else {
                prev.next = slow.next;
            }

            return listNode;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
