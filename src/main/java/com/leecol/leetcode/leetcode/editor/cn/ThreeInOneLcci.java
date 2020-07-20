//三合一。描述如何只用一个数组来实现三个栈。
//
// 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。s
//tackNum表示栈下标，value表示压入的值。
//
// 构造函数会传入一个stackSize参数，代表每个栈的大小。
//
// 示例1:
//
//  输入：
//["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
//[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
// 输出：
//[null, null, null, 1, -1, -1, true]
//说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
//
//
// 示例2:
//
//  输入：
//["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
//[[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
// 输出：
//[null, null, null, null, 2, 1, -1, -1]
//
// Related Topics 设计
// 👍 12 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 03.01,三合一
 */
public class ThreeInOneLcci {
    public static void main(String[] args) {
        TripleInOne tripleInOne = new ThreeInOneLcci().new TripleInOne(1);
        tripleInOne.push(0, 1);
        tripleInOne.push(0, 2);
        tripleInOne.pop(0);
        tripleInOne.pop(0);
        tripleInOne.pop(0);
        System.out.println(tripleInOne.isEmpty(0));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TripleInOne {
        private final int stackCount = 3;
        private int stackSize;
        private int[] stacks;
        private Map<Integer, Integer> stackMap;

        public TripleInOne(int stackSize) {
            this.stackSize = stackSize;
            stacks = new int[stackSize * stackCount];
            stackMap = new HashMap<>(stackCount);

            int i = 0;
            while (i < stackCount) {
                stackMap.put(i++, 0);
            }
        }

        public void push(int stackNum, int value) {
            if (stackNum >= stackCount || stackNum < 0) {
                return;
            }

            if (stackMap.get(stackNum) >= stackSize) {
                return;
            }

            int index = stackNum * stackSize + stackMap.get(stackNum);

            stacks[index] = value;

            stackMap.computeIfPresent(stackNum, (key, val) -> val + 1);
        }

        public int pop(int stackNum) {
            if (stackNum >= stackCount || stackNum < 0) {
                return -1;
            }

            if (stackMap.get(stackNum) <= 0) {
                return -1;
            }

            int index = stackNum * stackSize + stackMap.get(stackNum) - 1;

            stackMap.computeIfPresent(stackNum, (key, val) -> val - 1);

            return stacks[index];
        }

        public int peek(int stackNum) {
            if (stackNum >= stackCount || stackNum < 0) {
                return -1;
            }

            if (stackMap.get(stackNum) <= 0) {
                return -1;
            }

            int index = stackNum * stackSize + stackMap.get(stackNum) - 1;

            return stacks[index];
        }

        public boolean isEmpty(int stackNum) {
            if (stackNum >= stackCount || stackNum < 0) {
                return true;
            }

            if (stackMap.get(stackNum) <= 0) {
                return true;
            }

            return false;
        }
    }

    /**
     * Your TripleInOne object will be instantiated and called as such:
     * TripleInOne obj = new TripleInOne(stackSize);
     * obj.push(stackNum,value);
     * int param_2 = obj.pop(stackNum);
     * int param_3 = obj.peek(stackNum);
     * boolean param_4 = obj.isEmpty(stackNum);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
