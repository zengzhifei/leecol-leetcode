//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例:
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
//
// Related Topics 链表
// 👍 557 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

import com.leecol.leetcode.leetcode.editor.cn.tool.ListNode;

/**
 * 24,两两交换链表中的节点
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        ListNode listNode = solution.swapPairs(ListNode.build(1));
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
        public ListNode swapPairs(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode slow = head;
            ListNode fast = head.next;
            ListNode prev = null;

            ListNode listNode = fast;

            while (fast != null) {
                ListNode next = fast.next;

                fast.next = slow;
                slow.next = next;

                if (prev != null) {
                    prev.next = fast;
                }

                prev = slow;
                slow = slow.next;

                if (next != null) {
                    fast = next.next;
                } else {
                    //    System.out.println(2);
                    break;
                }
                //   System.out.println(1);
            }

            return listNode == null ? slow : listNode;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
