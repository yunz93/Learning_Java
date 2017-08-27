package interview.nowcoder;

import java.util.Scanner;

public class DNA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] strs = in.nextLine().split(" ");
            String s1 = strs[0];
            String s2 = strs[1];
            int res = 0;
            if (s1.length() != s2.length()) {
                //
            }
            for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (((c1 == 'A' && c2 == 'T') || (c1 == 'T' && c2 == 'A')) || ((c1 == 'C' && c2 == 'G') || (c1 == 'G' && c2 == 'C'))) {
                } else {
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
