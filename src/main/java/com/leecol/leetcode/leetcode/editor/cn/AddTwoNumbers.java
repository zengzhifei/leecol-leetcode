//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学

package com.leecol.leetcode.leetcode.editor.cn;

/**
 * 2,两数相加
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode l1 = new AddTwoNumbers().new ListNode(1);
        l1.next = new AddTwoNumbers().new ListNode(8);
        ListNode l2 = new AddTwoNumbers().new ListNode(0);
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode listNode = new ListNode(0);

            ListNode result = listNode;

            while (l1 != null && l2 != null) {
                int val = (l1.val + l2.val + listNode.val) % 10;
                int carry = (l1.val + l2.val + listNode.val - val) / 10;

                listNode.val = val;

                if (l1.next != null || l2.next != null || carry > 0) {
                    listNode.next = new ListNode(carry);
                    listNode = listNode.next;
                }

                l1 = l1.next;
                l2 = l2.next;
            }

            while (l1 != null) {
                int val = (l1.val + listNode.val) % 10;
                int carry = (l1.val + listNode.val - val) / 10;
                listNode.val = val;
                if (l1.next != null || carry > 0) {
                    listNode.next = new ListNode(carry);
                    listNode = listNode.next;
                }
                l1 = l1.next;
            }

            while (l2 != null) {
                int val = (l2.val + listNode.val) % 10;
                int carry = (l2.val + listNode.val - val) / 10;
                listNode.val = val;
                if (l2.next != null || carry > 0) {
                    listNode.next = new ListNode(carry);
                    listNode = listNode.next;
                }
                l2 = l2.next;
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
