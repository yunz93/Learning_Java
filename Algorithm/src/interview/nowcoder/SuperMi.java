package interview.nowcoder;

import java.util.Scanner;

public class SuperMi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            long n = in.nextLong();
            int p;
            int q;

            double ceil = Math.log10(n) / Math.log10(2);
            for (q = 2; q <= ceil; q++){
                p = (int) Math.pow(n, 1.0 / q);
                //double转换为int会丢失，所以下面要再次判断

                if (Math.pow(p, q) == n && isprime(p)){
                    System.out.println(p + " " + q);
                    break;
                }
            }

            if (q > ceil)
                System.out.println("No");
        }
    }

    /**
     * 判断是否为素数
     * @param n
     * @return
     */
    private static boolean isprime(long n) {
        double s = Math.sqrt(n);
        for (int i = 2; i <= s; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}
