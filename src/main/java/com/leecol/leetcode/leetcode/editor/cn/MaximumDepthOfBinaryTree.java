//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索
// 👍 594 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

/**
 * 104,二叉树的最大深度
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        TreeNode treeNode = new MaximumDepthOfBinaryTree().new TreeNode(1);
        treeNode.left = new MaximumDepthOfBinaryTree().new TreeNode(2);
        treeNode.right = new MaximumDepthOfBinaryTree().new TreeNode(2);
        treeNode.left.left = new MaximumDepthOfBinaryTree().new TreeNode(3);
        treeNode.left.right = new MaximumDepthOfBinaryTree().new TreeNode(4);
        treeNode.right.left = new MaximumDepthOfBinaryTree().new TreeNode(4);
        treeNode.right.right = new MaximumDepthOfBinaryTree().new TreeNode(3);
        treeNode.right.right.right = new MaximumDepthOfBinaryTree().new TreeNode(3);
        System.out.println(solution.maxDepth(treeNode));
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
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return countDepth(root.left, root.right, 1);
        }

        private int countDepth(TreeNode left, TreeNode right, int depth) {
            if (left == null && right == null) {
                return depth;
            } else if (left != null && right == null) {
                return countDepth(left.left, left.right, depth + 1);
            } else if (left == null) {
                return countDepth(right.left, right.right, depth + 1);
            } else {
                return Math.max(countDepth(left.left, left.right, depth + 1), countDepth(right.left, right.right,
                        depth + 1));
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
