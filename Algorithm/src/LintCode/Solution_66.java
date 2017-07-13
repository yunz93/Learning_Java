package LintCode;

import java.util.ArrayList;

/**
 * LintCode 66
 * 二叉树的前序遍历
 * 递归版
 * Created by Administrator on 2017/7/13 0013.
 */
public class Solution_66 {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    ArrayList<Integer> al = new ArrayList<>();

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        if (null == root)
            return al;

        al.add(root.val);

        if (root.left != null)
            preorderTraversal(root.left);
        if (root.right != null)
            preorderTraversal(root.right);

        return al;
    }
}
