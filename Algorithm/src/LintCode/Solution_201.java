package LintCode;

/**
 * LintCode 201
 * 线段树的构造
 * Created by Administrator on 2017/7/20 0020.
 */
public class Solution_201 {
    /**
     *@param start, end: Denote an segment / interval
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int start, int end) {
        // write your code here
        if(start > end) { // check core case
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end);

        if(start < end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid);
            root.right = build(mid+1, end);

        }
        return root;
    }
}
