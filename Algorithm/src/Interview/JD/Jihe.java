package Interview.JD;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 京东2017年笔试题 集合
 * 将两个集合合并为一个集合，升序输出
 */
public class Jihe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();

            Set<Integer> a = new TreeSet<>();
            for (int i = 0; i < m; i++) {
                a.add(in.nextInt());
            }

            for (int i = 0; i < n; i++) {
                a.add(in.nextInt());
            }

            Iterator it = a.iterator();

            while (it.hasNext()) {
                System.out.print(it.next());
                if (it.hasNext()) {
                    System.out.print(" ");
                }
            }
        }
    }
}
