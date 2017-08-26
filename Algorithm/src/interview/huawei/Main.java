package interview.huawei;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            // 处理输入
            String s = in.nextLine();
            String[] arr = s.split(" ");
            int n1 = Integer.parseInt(arr[0]);
            int n2 = Integer.parseInt(arr[1]);
            String str = arr[2];

        }

    }

    private static long power(int n, int i) {
        if (i == 0)
            return 1;
        if (i == 1)
            return n;
        long res = 1;
        for (int j = 0; j < i; ++j) {
            res *= n;
        }
        return res;
    }
}
