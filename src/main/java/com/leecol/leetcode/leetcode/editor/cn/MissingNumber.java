//给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
//
//
//
// 示例 1:
//
// 输入: [3,0,1]
//输出: 2
//
//
// 示例 2:
//
// 输入: [9,6,4,2,3,5,7,0,1]
//输出: 8
//
//
//
//
// 说明:
//你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
// Related Topics 位运算 数组 数学
// 👍 291 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

/**
 * 268,缺失数字
 */
public class MissingNumber {
    public static void main(String[] args) {
        Solution solution = new MissingNumber().new Solution();
        System.out.println(solution.missingNumber(new int[] {3, 0, 1}));
        System.out.println(solution.missingNumber(new int[] {2, 3, 7, 1, 6, 4, 9, 8, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber(int[] nums) {
            int num1 = nums[0];
            for (int i = 1; i < nums.length; i++) {
                num1 ^= nums[i];
            }

            int num2 = 0;
            for (int i = 1; i <= nums.length; i++) {
                num2 ^= i;
            }

            return num1 ^ num2;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
