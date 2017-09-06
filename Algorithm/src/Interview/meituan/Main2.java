package Interview.meituan;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int[] s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = in.nextInt();
            }
            boolean result = solution(n, s);
            if (result) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        in.close();
    }

    private static boolean solution(int n, int[] s) {
        Arrays.sort(s);
        int sum = 0;
        for (int i = 0; i < n-1; i++) {
            sum += s[i];
        }
        if (s[n-1] < sum) {
            return true;
        }
        return false;
    }
}