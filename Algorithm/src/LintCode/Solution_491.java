package LintCode;

/**
 * Solution 491
 * 简单题，判断一个数是否是回文数
 * 将数倒过来与原数比较即可
 */

public class Solution_491 {
    /*
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public boolean isPalindrome(int num) {
        // write your code here
        int m = reverse(num);
        if (m == num) {
            return true;
        } else {
            return false;
        }
    }

    public int reverse(int n) {
        int temp = 0;// 临时变量
        int j = 0;// 倒置后的数字
        temp = n;// 将输入的数字赋值给临时变量
        while (temp != 0) {
            j = j * 10 + temp % 10;
            temp /= 10;
        }
        return j;
    }
}
