//请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(
//1)。 示例： MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
// minStack.push(-3); minStack.getMin();   --> 返回 -3. minStack.pop(); minStack.top
//();      --> 返回 0. minStack.getMin();   --> 返回 -2. Related Topics 栈
// 👍 19 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 面试题 03.02,栈的最小值
 */
public class MinStackLcci {
    public static void main(String[] args) {
        MinStack minStack = new MinStackLcci().new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        private int length = 0;
        private int[] stack;
        private int[] minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new int[length];
            minStack = new int[length];
        }

        public void push(int x) {
            length++;
            int[] newStack = new int[length];
            System.arraycopy(stack, 0, newStack, 0, length - 1);
            newStack[length - 1] = x;
            stack = newStack;
            minStack = newStack.clone();
            Arrays.sort(minStack);
        }

        public void pop() {
            length--;
            int[] newStack = new int[length];
            System.arraycopy(stack, 0, newStack, 0, length);
            stack = newStack;
            minStack = newStack.clone();
            Arrays.sort(minStack);
        }

        public int top() {
            return stack[length - 1];
        }

        public int getMin() {
            return minStack[0];
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

}
