package LintCode;

/**
 * LintCode 03
 * 统计数字
 * Created by Administrator on 2017/7/15 0015.
 */
public class Solution_03 {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int a = 0;
        int num = 0;

        if(k==0) {
            num=1;
        }

        for (int i = 0; i <= n; i++) {
            int temp = i;
            while (temp != 0) {
                a = temp % 10;

                if (a == k) {
                    num++;
                }
                temp /= 10;
            }
        }

        return num;
    }
}
