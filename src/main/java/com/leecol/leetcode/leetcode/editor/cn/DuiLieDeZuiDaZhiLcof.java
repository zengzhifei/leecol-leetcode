//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都
//是O(1)。
//
// 若队列为空，pop_front 和 max_value 需要返回 -1
//
// 示例 1：
//
// 输入:
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
//
//
// 示例 2：
//
// 输入:
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]
//
//
//
//
// 限制：
//
//
// 1 <= push_back,pop_front,max_value的总操作数 <= 10000
// 1 <= value <= 10^5
//
// Related Topics 栈 Sliding Window
// 👍 121 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II,队列的最大值
 */
public class DuiLieDeZuiDaZhiLcof {
    public static void main(String[] args) {
        MaxQueue maxQueue = new DuiLieDeZuiDaZhiLcof().new MaxQueue();
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        maxQueue.push_back(46);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(868);
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(525);
        System.out.println(maxQueue.pop_front());

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MaxQueue {
        private Queue<Integer> queue = new LinkedList<>();
        private Deque<Integer> deque = new LinkedList<>();

        public MaxQueue() {

        }

        public int max_value() {
            if (deque.size() == 0) {
                return -1;
            }

            return deque.getFirst();
        }

        public void push_back(int value) {
            queue.add(value);

            while (deque.size() > 0 && deque.getLast() < value) {
                deque.removeLast();
            }

            deque.add(value);
        }

        public int pop_front() {
            Integer val = queue.poll();

            if (val == null) {
                return -1;
            }

            if (val.equals(deque.getFirst())) {
                deque.removeFirst();
            }

            return val;
        }
    }

    /**
     * Your MaxQueue object will be instantiated and called as such:
     * MaxQueue obj = new MaxQueue();
     * int param_1 = obj.max_value();
     * obj.push_back(value);
     * int param_3 = obj.pop_front();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
