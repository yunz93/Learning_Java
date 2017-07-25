package LintCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * LintCode 11
 * 二叉查找树中搜索区间
 * 最简单的思路，就是中序遍历一遍，然后把区间内的节点加入到list中
 * Created by Administrator on 2017/7/24 0024.
 */
public class Solution_11 {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
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
                if (p.val >= k1 && p.val <= k2)
                    al.add(p.val);
                p = p.right;
            }
        }

        return al;
    }
}
