package LintCode;

import java.util.ArrayList;
import java.util.List;

/**
 * LintCode 84
 * 落单的数 III
 * 给出2*n + 2个的数字，除其中两个数字之外其他每个数字均出现两次，找到这两个数字。
 * 首先将所有数字求异或，得到的数是两个落单的数字的异或。
 * 由于这两个数字肯定不同，则他们的异或一定有值1的位。
 * 找到第一个值为1的位，以这一位为标志，将数组中的数分为两组。
 * 一组是该位为1的数字，一组是该位为0的数字。
 * 对这两组数分别进行异或，即可找到这两个不同的数字。
 * Created by Administrator on 2017/7/28 0028.
 */
public class Solution_84 {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        if (null == A || A.length <= 0) {
            return null;
        }

        int temp = A[0];
        for (int i = 1; i < A.length; i++) {
            temp ^= A[i];
        }

        int k = findFirstBit1(temp);
        Boolean flagA = true;
        Boolean flagB = true;

        int resA = 0;
        int resB = 0;

        for (int i = 0; i < A.length; i++) {
            if ((A[i] >> k & 1) == 0) {
                if (flagA) {
                    resA = A[i];
                    flagA = false;
                } else {
                    resA ^= A[i];
                }
            } else {
                if (flagB) {
                    resB = A[i];
                    flagB = false;
                } else {
                    resB ^= A[i];
                }
            }
        }

        List<Integer> ls = new ArrayList<>();
        ls.add(resA);
        ls.add(resB);
        return ls;
    }

    int findFirstBit1(int temp) {
        int res = 0;
        while ((temp & 1) == 0) {
            temp = temp >> 1;
            res++;
        }

        return res;
    }
}
