package LintCode;

/**
 * LintCode 517 丑数
 * 判断一个数是否是丑数，即只有2，3，5质因数
 * 直接把数一直除以三个质因数，如果最后为1，即为丑数
 * Created by Administrator on 2017/8/9 0009.
 */
public class Solution_517 {
    /**
     * @param num an integer
     * @return true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
        // Write your code here
        if (num == 0) {
            return false;
        }

        while (num % 2 == 0) {
            num /= 2;
        }

        while (num % 3 == 0) {
            num /= 3;
        }

        while (num % 5 == 0) {
            num /= 5;
        }

        return (num == 1) ? true : false;
    }
}
