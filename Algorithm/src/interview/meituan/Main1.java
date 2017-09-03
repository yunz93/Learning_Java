package interview.meituan;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = in.nextInt();
            }
            int k = in.nextInt();
            int result = solution(n, p, k);
            System.out.println(result);
        }
        in.close();
    }

    private static int solution(int n, int[] p, int k) {
        if (p == null || n <= 0) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = p[i];
            int count = 1;
            for (int j = i+1; j < n; j++) {
                if (max > n-i-1) {
                    return max;
                }
                sum += p[j];
                if (sum % k == 0) {
                    count = j - i + 1;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}