package Interview.JD;

import java.util.Scanner;

/**
 * 京东2017笔试题 进制均值
 * 求一个十进制数，从2~N-1进制表达式个位数之和的均值
 * 典型的进制转换题
 */
public class MeanValue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            solution(num);
        }
    }

    private static void solution(int num) {
        // 进制转换的个数
        int n = num - 2;
        int sum = 0;

        for (int i = 2; i < num; i++) {
            sum += fun(num, i);
        }

        // 求最大公约数
        int con = fun2(sum, n);
        System.out.println(sum/con + "/" + n/con);
    }

    // 求最大公约数
    private static int fun2(int a, int b) {
        while (a%b != 0) {
            int c = a%b;
            a = b;
            b = c;
        }
        return b;
    }

    // 求x进制转换各位上的和
    private static int fun(int num, int x) {
        int res = 0;
        while (num != 0) {
            res += num % x;
            num /= x;
        }
        return res;
    }
}
