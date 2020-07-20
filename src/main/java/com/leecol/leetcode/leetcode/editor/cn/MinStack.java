//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//
// push(x) —— 将元素 x 推入栈中。
// pop() —— 删除栈顶的元素。
// top() —— 获取栈顶元素。
// getMin() —— 检索栈中的最小元素。
//
//
//
//
// 示例:
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
//
//
//
//
// 提示：
//
//
// pop、top 和 getMin 操作总是在 非空栈 上调用。
//
// Related Topics 栈 设计
// 👍 605 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

/**
 * 155,最小栈
 */
//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    private ListNode listNode;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        if (listNode == null) {
            listNode = new ListNode(x, x, null, null);
        } else {
            listNode.next = new ListNode(x, Math.min(listNode.getMinVal(), x), listNode, null);
            listNode = listNode.next;
        }
    }

    public void pop() {
        if (listNode == null) {
            return;
        }

        ListNode prev = listNode.getPrev();
        if (prev != null) {
            prev.next = null;
        }

        listNode = prev;
    }

    public int top() {
        if (listNode == null) {
            throw new RuntimeException("MinStack is empty");
        } else {
            return listNode.getVal();
        }
    }

    public int getMin() {
        if (listNode == null) {
            throw new RuntimeException("MinStack is empty");
        } else {
            return listNode.getMinVal();
        }
    }

    private class ListNode {
        private int val;
        private int minVal;
        private ListNode prev;
        private ListNode next;

        public ListNode(int val, int minVal, ListNode prev, ListNode next) {
            this.val = val;
            this.minVal = minVal;
            this.prev = prev;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getMinVal() {
            return minVal;
        }

        public void setMinVal(int minVal) {
            this.minVal = minVal;
        }

        public ListNode getPrev() {
            return prev;
        }

        public void setPrev(ListNode prev) {
            this.prev = prev;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
