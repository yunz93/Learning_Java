package Interview.JD;

import java.util.Scanner;

/**
 * 京东2017笔试题 幸运数
 * 如果一个数的十进制表示各位数之和等于其二进制表示各位数之和，则为幸运数
 * 求小于等于n的幸运数个数
 * 还是进制转换的问题
 */
public class LuckyNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            solution(num);
        }
    }

    private static void solution(int num) {
        // 进制转换的个数

        int result = 0;

        for (int i = 1; i <= num; i++) {
            if (isLucky(i)) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean isLucky(int num) {
        int sum2 = fun(num, 2);
        int sum10 = fun(num, 10);

        return sum2 == sum10;
    }

    private static int fun(int num, int x) {
        int res = 0;

        while (num != 0) {
            res += num % x;
            num /= x;
        }
        return res;
    }
}
