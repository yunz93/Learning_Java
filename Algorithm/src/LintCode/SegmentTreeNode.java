package LintCode;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public class SegmentTreeNode {
    public int start, end, max;
    public SegmentTreeNode left, right;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = this.right = null;
    }

    public SegmentTreeNode(int start, int end, int max) {
        this.start = start;
        this.end = end;
        this.max = max;
        this.left = this.right = null;
    }
}
