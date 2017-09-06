package Interview.dji;

import java.util.Scanner;

public class DifferentCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            long[] num = new long[n];
            for (int i = 0; i < n; i++) {
                num[i] = in.nextLong();
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        res += solution(num[i], num[j]);
                    }
                }
            }
            System.out.println(res/2);
        }
    }

    private static int solution(long a, long b)
    {
        long m = a ^ b;
        int num = 0;
        while(m != 0)
        {
            m &= (m-1);
            num++;
        }
        return num;
    }
}
