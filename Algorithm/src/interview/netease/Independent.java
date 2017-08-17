package interview.netease;

import java.util.Scanner;

public class Independent {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long x = in.nextLong();
        long f = in.nextLong();
        long d = in.nextLong();
        long p = in.nextLong();

        System.out.println(solution(x, f, d, p));
        in.close();
    }

    private static long solution(long x, long f, long d, long p) {
        long max = (long)(d/x);
        long rest = 0;

        if (f > max) {
            return max;
        } else {
            rest = (long)((d - f*x)/(x+p));
        }
        return rest + f;
    }
}
