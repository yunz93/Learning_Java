package LintCode;

/**
 * LintCode 203
 * 线段树的修改
 */
public class Solution_203 {
    /**
     *@param root, index, value: The root of segment tree and
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if(root.start >= index && root.end <= index) {
            // 查找到
            root.max = value;
            return;
        }
        // 查询
        int mid = (root.start + root.end) / 2;

        if(root.start <= index && index <= mid) {
            modify(root.left, index, value);
        }
        if(mid < index && index <= root.end) {
            modify(root.right, index, value);
        }
        //更新
        root.max = Math.max(root.left.max, root.right.max);
    }
}
