package LintCode;

/**
 * LintCode 88
 * 最近公共祖先
 * Created by Administrator on 2017/7/15 0015.
 */
public class Solution_88 {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */

    /**
     * 递归方法
     * 当遍历到一个root点的时候
     * 1.判断root是不是null如果root为null，那么就无所谓祖先节点，直接返回null就好了
     * 2.如果root的左子树存在p，右子树存在q，那么root肯定就是最近祖先
     * 如果pq都在root的左子树，那么就需要递归root的左子树，右子树同理
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root == null || root == A || root == B)
            return root;

        TreeNode left = lowestCommonAncestor1(root.left, A, B);
        TreeNode right = lowestCommonAncestor1(root.right, A, B);

        if(left != null && right != null){
            return root;
        }else{
            return left == null ? right : left;
        }
    }

    /**
     * 非递归方法
     */

}
