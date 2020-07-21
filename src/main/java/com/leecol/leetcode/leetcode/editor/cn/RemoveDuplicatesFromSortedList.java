//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
// 示例 1:
//
// 输入: 1->1->2
//输出: 1->2
//
//
// 示例 2:
//
// 输入: 1->1->2->3->3
//输出: 1->2->3
// Related Topics 链表
// 👍 342 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

import com.leecol.leetcode.leetcode.editor.cn.tool.ListNode;

/**
 * 83,删除排序链表中的重复元素
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
        ListNode listNode = ListNode.build(1, 1, 2, 3, 3);
        ListNode ret = solution.deleteDuplicates(listNode);
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode preListNode = head;
            ListNode ret = preListNode;

            Set<Integer> sets = new HashSet<>();
            sets.add(preListNode.val);

            head = head.next;

            while (head != null) {
                if (sets.contains(head.val)) {
                    preListNode.next = head.next;
                } else {
                    sets.add(head.val);
                    preListNode.next = head;
                    preListNode = preListNode.next;
                }

                head = head.next;
            }

            return ret;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
