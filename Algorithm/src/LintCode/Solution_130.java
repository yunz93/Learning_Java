package LintCode;

/**
 * LintCode 130
 * 堆化，构造最小堆
 * Created by Administrator on 2017/7/25 0025.
 */
public class Solution_130 {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        if (null == A || A.length <= 0)
            return;

        for(int i = A.length / 2; i >= 0; i--) {
            heapify(A, i);
        }
    }

    void heapify(int[] A, int last) {
        int left = 2 * last + 1;
        int right = 2* last + 2;
        int small = last;
        if(left < A.length && A[left] < A[small]) {
            small = left;
        }
        if(right < A.length && A[right] < A[small]) {
            small = right;
        }
        if(small != last) {
            int tmp = A[small];
            A[small] = A[last];
            A[last] = tmp;
            heapify(A, small);
        }
    }
}
