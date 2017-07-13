package LintCode;

import java.util.ArrayList;
import java.util.List;

/**
 * LintCode 376
 * 求二叉树的路径和
 * Created by Administrator on 2017/7/13 0013.
 */
public class Solution_376 {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    private List<List<Integer>> listAll = new ArrayList<>();
    private List<Integer> list = new ArrayList<Integer>();

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        if(root == null)
            return listAll;

        list.add(root.val);
        target -= root.val;

        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        binaryTreePathSum(root.left, target);
        binaryTreePathSum(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }
}
