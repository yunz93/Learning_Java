package LintCode;

/**
 * LintCode 439
 * 线段树的构造II
 * Created by Mahe on 2017/7/21.
 */
public class Solution_439 {
    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        return buildTree(0, A.length - 1, A);
    }

    public SegmentTreeNode buildTree(int start, int end, int[] A) {
        if (start > end)
            return null;

        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }

        SegmentTreeNode node = new SegmentTreeNode(start, end, A[start]);

        int mid = (start + end) / 2;

        node.left = this.buildTree(start, mid, A);
        node.right = this.buildTree(mid + 1, end, A);
        node.max = Math.max(node.left.max, node.right.max);
        return node;
    }
}
