//给定两个二叉树，编写一个函数来检验它们是否相同。
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
//
// 示例 1:
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true
//
// 示例 2:
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
//
//
// 示例 3:
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
//
// Related Topics 树 深度优先搜索
// 👍 394 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

/**
 * 100,相同的树
 */
public class SameTree {
    public static void main(String[] args) {
        Solution solution = new SameTree().new Solution();
        TreeNode treeNode1 = new SameTree().new TreeNode(1);
        treeNode1.left = new SameTree().new TreeNode(2);
        treeNode1.right = new SameTree().new TreeNode(1);

        TreeNode treeNode2 = new SameTree().new TreeNode(1);
        treeNode2.left = new SameTree().new TreeNode(1);
        treeNode2.right = new SameTree().new TreeNode(2);

        System.out.println(solution.isSameTree(treeNode1, treeNode2));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }

            if (p != null && q != null) {
                if (p.val != q.val) {
                    return false;
                }

                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }

            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
