package LintCode;

import java.util.ArrayList;
import java.util.List;

/**
 * LintCode 480
 * 求二叉树所有路径
 * Created by Administrator on 2017/7/13 0013.
 */
public class Solution_480 {
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> ls = new ArrayList<>();

        if(root == null)
            return ls;

        binaryTreePathsCore(root, ls, String.valueOf(root.val));

        return ls;
    }

    void binaryTreePathsCore(TreeNode node, List<String> ls, String pathStr) {
        // 叶子节点，将该路径String加入list
        if (node.left == null && node.right == null) {
            ls.add(pathStr);
        }

        if (node.left != null) {
            binaryTreePathsCore(node.left, ls, pathStr + "->" + String.valueOf(node.left.val));
        }

        if (node.right != null) {
            binaryTreePathsCore(node.right, ls, pathStr + "->" + String.valueOf(node.right.val));
        }
    }
}
