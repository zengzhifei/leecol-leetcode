//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其自底向上的层次遍历为：
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
//
// Related Topics 树 广度优先搜索
// 👍 259 👎 0

package com.leecol.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 107,二叉树的层次遍历 II
 */
public class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();

        TreeNode treeNode = new BinaryTreeLevelOrderTraversalIi().new TreeNode(0);
        treeNode.left = new BinaryTreeLevelOrderTraversalIi().new TreeNode(2);
        treeNode.right = new BinaryTreeLevelOrderTraversalIi().new TreeNode(4);
        treeNode.left.left = new BinaryTreeLevelOrderTraversalIi().new TreeNode(1);
        treeNode.left.left.left = new BinaryTreeLevelOrderTraversalIi().new TreeNode(5);
        treeNode.left.left.right = new BinaryTreeLevelOrderTraversalIi().new TreeNode(1);
        treeNode.right.left = new BinaryTreeLevelOrderTraversalIi().new TreeNode(3);
        treeNode.right.right = new BinaryTreeLevelOrderTraversalIi().new TreeNode(-1);
        treeNode.right.left.right = new BinaryTreeLevelOrderTraversalIi().new TreeNode(6);
        treeNode.right.right.right = new BinaryTreeLevelOrderTraversalIi().new TreeNode(8);

        System.out.println(solution.levelOrderBottom(treeNode));
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();

            putTreeNode(root, 0, lists);

            List<List<Integer>> ret = new ArrayList<>();
            for (int i = lists.size() - 1; i >= 0; i--) {
                ret.add(lists.get(i));
            }

            return ret;
        }

        private void putTreeNode(TreeNode root, int depth, List<List<Integer>> lists) {
            if (root == null) {
                return;
            }

            List<Integer> list;

            if (lists.size() > depth) {
                list = lists.get(depth);
                list.add(root.val);
                lists.set(depth, list);
            } else {
                list = new ArrayList<>();
                list.add(root.val);
                lists.add(list);
            }

            if (root.left != null) {
                putTreeNode(root.left, depth + 1, lists);
            }

            if (root.right != null) {
                putTreeNode(root.right, depth + 1, lists);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
