//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 )
//
//
//
// 示例 1：
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
//
//
// 示例 2：
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
//
//
// 提示：
//
//
// 1 <= values <= 10000
// 最多会对 appendTail、deleteHead 进行 10000 次调用
//
// Related Topics 栈 设计
// 👍 92 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

import java.util.Stack;

/**
 * 剑指 Offer 09,用两个栈实现队列
 */
public class YongLiangGeZhanShiXianDuiLieLcof {
    public static void main(String[] args) {
        CQueue cQueue = new YongLiangGeZhanShiXianDuiLieLcof().new CQueue();
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> queue = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            while (!queue.empty()) {
                stack.push(queue.pop());
            }

            stack.push(value);

            while (!stack.empty()) {
                queue.push(stack.pop());
            }
        }

        public int deleteHead() {
            if (queue.empty()) {
                return -1;
            }

            return queue.pop();
        }
    }

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
