package interview.huawei;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String[] arr = s.split(" ");
            int n1 = Integer.parseInt(arr[0]);
            int n2 = Integer.parseInt(arr[1]);
            String str = arr[2];
            String res = solution(n1, n2, str);
            System.out.println(res);
        }
    }

    private static String solution(int n1, int n2, String num) {
        // 先转换为10进制
        String res = null;
        int n = 0;

        n = Integer.valueOf(num, n1);
        res = Integer.toString(n, n2);
        return res;
    }
}
