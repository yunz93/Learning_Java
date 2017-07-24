package LintCode;

/**
 * LintCode 202
 * 线段树的查询
 * Created by Mahe on 2017/7/21.
 */
public class Solution_202 {
    /**
     *@param root, start, end: The root of segment tree and
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(root == null) {
            return Integer.MIN_VALUE;

        }
        if(start == root.start && root.end == end) {
            // 相等
            return root.max;

        }
        int mid = (root.start + root.end)/2;
        int leftmax = Integer.MIN_VALUE, rightmax = Integer.MIN_VALUE;

        // 左子区
        if(start <= mid) {
            leftmax = query(root.left, start, Math.min(mid,end));
        }
        // 右子区
        if(mid < end) {
            rightmax = query(root.right, Math.max(mid+1,start), end);
        }

        // 不相交
        return Math.max(leftmax, rightmax);
    }
}
