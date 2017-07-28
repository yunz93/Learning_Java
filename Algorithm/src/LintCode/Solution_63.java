package LintCode;

/**
 * LintCode 63
 * 搜索旋转排序数组2
 * 在搜索选择排序数组的那题的基础上，增加了数组中有重复值的设定
 * 所以相对上题，也需要增加一个判断mid和left相等的情况
 */
public class Solution_63 {
    public boolean search(int[] A, int target) {
        // write your code here
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if(A[mid] == target)
                return true;
            if(A[mid] > A[left]){
                if(A[mid] > target && target > A[left])
                    right = mid;
                else {
                    left = mid+1;
                }
            }
            else if(A[left] > A[mid]){
                if(A[mid] < target && target <= A[right])
                    left = mid + 1;
                else
                    right = mid;
            }
            else {
                left++;
            }

        }
        return false;
    }
}
