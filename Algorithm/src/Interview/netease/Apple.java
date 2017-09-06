package Interview.netease;

import java.util.Scanner;

/**
 * 网易17年笔试题
 * 分苹果
 * Created by Administrator on 2017/8/11 0011.
 */
public class Apple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];

            int sum = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            int res = fenApple(nums, n);

            System.out.println(res);
        }
    }

    private static int fenApple(int[] nums, int n) {
        int sum = 0;
        int times = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum%n != 0) {
            return -1;
        }

        int avg = sum / n;
        for (int i = 0; i < n; i++) {
            int temp = Math.abs(nums[i] - avg);
            if (temp % 2 != 0) {
                return -1;
            }
            times += temp/2;
        }
        return times/2;
    }
}
