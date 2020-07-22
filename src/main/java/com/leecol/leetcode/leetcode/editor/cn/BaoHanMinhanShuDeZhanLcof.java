//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
//
//
//
// 示例:
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
//
//
//
//
// 提示：
//
//
// 各函数的调用总次数不超过 20000 次
//
//
//
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
// Related Topics 栈 设计
// 👍 28 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

/**
 * 剑指 Offer 30,包含min函数的栈
 */
public class BaoHanMinhanShuDeZhanLcof {
    public static void main(String[] args) {
        MinStack minStack = new BaoHanMinhanShuDeZhanLcof().new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        private ListNode listNode = null;

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            if (listNode == null) {
                listNode = new ListNode(x, x, null, null);
            } else {
                listNode.next = new ListNode(x, Math.min(listNode.minVal, x), listNode, null);
                listNode = listNode.next;
            }
        }

        public void pop() {
            if (listNode == null) {
                return;
            }

            ListNode prev = listNode.prev;
            if (prev != null) {
                prev.next = null;
            }

            listNode = prev;
        }

        public int top() {
            if (listNode == null) {
                throw new RuntimeException("stack is empty");
            }

            return listNode.val;
        }

        public int min() {
            if (listNode == null) {
                throw new RuntimeException("stack is empty");
            }

            return listNode.minVal;
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
     * int param_4 = obj.min();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
