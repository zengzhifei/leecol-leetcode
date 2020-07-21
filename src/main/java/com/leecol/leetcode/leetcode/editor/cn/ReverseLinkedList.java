//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
// Related Topics 链表
// 👍 1105 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

import com.leecol.leetcode.leetcode.editor.cn.tool.ListNode;

/**
 * 206,反转链表
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        ListNode listNode = ListNode.build(1, 2, 3, 4, 5);
        ListNode.print(solution.reverseList(listNode));
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
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode prev = null, preprev = null;

            while (head != null) {
                prev = head;

                head = head.next;

                prev.next = preprev;
                preprev = prev;
            }

            return prev;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
