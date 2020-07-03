//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表

package com.leecol.leetcode.leetcode.editor.cn;

/**
 * 21,合并两个有序链表
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();

        ListNode l1 = new MergeTwoSortedLists().new ListNode();
        //l1.next = new MergeTwoSortedLists().new ListNode(2);
        //l1.next.next = new MergeTwoSortedLists().new ListNode(4);

        ListNode l2 = new MergeTwoSortedLists().new ListNode();
        //l2.next = new MergeTwoSortedLists().new ListNode(3);
        //l2.next.next = new MergeTwoSortedLists().new ListNode(4);

        ListNode listNode = solution.mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            }

            ListNode listNode = new ListNode();
            ListNode ret = listNode;

            while (l1 != null || l2 != null) {
                Integer val1 = null;
                Integer val2 = null;
                Integer val = null;

                if (l1 != null) {
                    val1 = l1.val;
                }

                if (l2 != null) {
                    val2 = l2.val;
                }

                if (val1 == null) {
                    val = val2;
                    l2 = l2.next;
                } else {
                    if (val2 == null || val1 <= val2) {
                        val = val1;
                        l1 = l1.next;
                    } else {
                        val = val2;
                        l2 = l2.next;
                    }
                }

                ret.val = val;

                if (l1 != null || l2 != null) {
                    ret.next = new ListNode();
                    ret = ret.next;
                }
            }

            return listNode;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
