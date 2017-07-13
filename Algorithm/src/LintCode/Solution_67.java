package LintCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * LintCode 67
 * 二叉树的中序遍历
 * 非递归版
 * Created by Administrator on 2017/7/13 0013.
 */
public class Solution_67 {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> al = new ArrayList<>();

        if (root == null)
            return al;

        TreeNode p = root;
        Stack<TreeNode> s = new Stack<>();

        while (!s.isEmpty() || p != null) {
            if (p != null) {
                s.push(p);
                p = p.left;
            } else {
                p = s.pop();
                al.add(p.val);
                p = p.right;
            }
        }

        return al;
    }
}
