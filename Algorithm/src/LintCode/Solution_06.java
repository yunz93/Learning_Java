package LintCode;

/**
 * LintCode 06
 * 合并排序数组
 * 利用第三个数组进行归并排序
 * Created by Administrator on 2017/7/28 0028.
 */
public class Solution_06 {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        if (A == null) {
            return B;
        }

        if (B == null) {
            return A;
        }
        int[] C = new int[A.length + B.length];

        int posA = 0;
        int posB = 0;
        int posC = 0;

        while (posA < A.length && posB < B.length) {
            if (A[posA] < B[posB]) {
                C[posC++] = A[posA++];
            } else {
                C[posC++] = B[posB++];
            }
        }

        while (posA < A.length) {
            C[posC++] = A[posA++];
        }

        while (posB < B.length) {
            C[posC++] = B[posB++];
        }

        return C;
    }
}
