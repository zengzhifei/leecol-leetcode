package com.leecol.leetcode.leetcode.editor.cn.tool;

/**
 * ListNodeTool
 *
 * @author zengzhifei
 * @date 2020/7/20 17:45
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode build(int... vals) {
        ListNode listNode = new ListNode(vals[0]);
        ListNode cur = listNode;
        for (int i = 1; i < vals.length; i++) {
            cur.next = new ListNode(vals[i]);
            cur = cur.next;
        }
        return listNode;
    }

    public static ListNode buildCycle(int... vals) {
        ListNode listNode = new ListNode(vals[0]);
        ListNode cur = listNode;
        for (int i = 1; i < vals.length; i++) {
            cur.next = new ListNode(vals[i]);
            cur = cur.next;
        }
        cur.next = listNode;

        return listNode;
    }

    public static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
