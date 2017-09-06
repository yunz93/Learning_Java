package Interview.netease;

import java.util.Scanner;

/**
 * 网易17年笔试题
 * 藏宝图
 * Created by Administrator on 2017/8/11 0011.
 */
public class OnePiece {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String t = scanner.nextLine();
            if (isSubString(s, t)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static boolean isSubString(String s, String t) {
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(index)) {
                index++;
                if (index == t.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
