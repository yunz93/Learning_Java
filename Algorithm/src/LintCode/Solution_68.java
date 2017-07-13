package LintCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * LintCode 68
 * 二叉树的后序遍历
 * 非递归版
 * Created by Administrator on 2017/7/13 0013.
 */
public class Solution_68 {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> al = new ArrayList<>();

        if (root == null)
            return al;

        TreeNode pCur = root;
        TreeNode pLastVisited = null;
        Stack<TreeNode> s = new Stack<>();

        while (pCur != null) {
            s.push(pCur);
            pCur = pCur.left;
        }

        while (!s.isEmpty()) {
            pCur = s.pop();
            if (pCur.right == null || pCur.right == pLastVisited) {
                al.add(pCur.val);
                pLastVisited = pCur;
            } else {
                s.push(pCur);
                pCur = pCur.right;

                while (pCur != null) {
                    s.push(pCur);
                    pCur = pCur.left;
                }
            }
        }

        return al;
    }
}
