//请判断一个链表是否为回文链表。
//
// 示例 1:
//
// 输入: 1->2
//输出: false
//
// 示例 2:
//
// 输入: 1->2->2->1
//输出: true
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 链表 双指针
// 👍 564 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

import com.leecol.leetcode.leetcode.editor.cn.tool.ListNode;

/**
 * 234,回文链表
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        ListNode listNode1 = ListNode.build(1,2);
        System.out.println(solution.isPalindrome(listNode1));
        ListNode listNode2 = ListNode.build(1,2,2,1);
        System.out.println(solution.isPalindrome(listNode2));
        ListNode listNode3 = ListNode.build(1,2,3,4,2,1);
        System.out.println(solution.isPalindrome(listNode3));
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
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }

            ListNode slow = head, fast = head;

            ListNode prev = null, preprev = null;

            while (fast != null) {
                if (fast.next != null) {
                    prev = slow;

                    slow = slow.next;
                    fast = fast.next.next;

                    prev.next = preprev;
                    preprev = prev;
                } else {
                    slow = slow.next;
                    break;
                }
            }

            while (prev != null) {
                if (prev.val != slow.val) {
                    return false;
                }

                prev = prev.next;
                slow = slow.next;
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
